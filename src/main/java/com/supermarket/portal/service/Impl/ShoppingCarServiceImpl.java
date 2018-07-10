package com.supermarket.portal.service.Impl;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.supermarket.common.utils.CookieUtils;
import com.supermarket.common.utils.ExceptionUtil;
import com.supermarket.common.utils.HttpClientUtil;
import com.supermarket.common.utils.JsonUtils;
import com.supermarket.common.utils.KklResult;
import com.supermarket.pojo.TbItem;
import com.supermarket.portal.pojo.CartItem;
import com.supermarket.portal.service.ShoppingCarService;

/**   
 * @ClassName: ShoppingCarServiceImpl   
 * @Description: shopping car manage service   
 * @author: KKL 
 * @date: 2018年7月9日 下午7:00:10      
 */  
@Service
public class ShoppingCarServiceImpl implements ShoppingCarService {
	
	@Value("${REST_BASIC_URL}")
	private String REST_BASIC_URL;
	
	@Value("${ITEM_BASE_INFO_URL}")
	private String itemBaseURL;
	
	@Value("${ITEM_CART_NAME_IN_COOKIE}")
	private String cartNameInCookie;

	/**   
	 * <p>Title: addItem</p>   
	 * <p>Description:
	 * 1.  query shopping car exist this kind of item by item id
	 * 	   if exist : item number increase the specified quantify on the basis of the original
	 * 	   if does not exist:
	 *     invoke supermarket-rest service query item basic information by item id 
	 *     set this kind of item information then add item list
	 *     write item list to cookie
	 * </p>   
	 * @param itemId
	 * @param num
	 * @return   
	 * @see com.supermarket.portal.service.ShoppingCarService#addItem(long, int)   
	 */ 
	@Override
	public KklResult addItem(HttpServletRequest request,HttpServletResponse response,long itemId, int num) {
		String doGetStr="";
		try {
			doGetStr = HttpClientUtil.doGet(REST_BASIC_URL+itemBaseURL+itemId);
			if (StringUtils.isBlank(doGetStr)) {
				System.out.println("rest service no response message");
				return KklResult.build(400, "rest service no response message");
			}
		} catch (Exception e) {
			e.printStackTrace();
			return KklResult.build(400, ExceptionUtil.getStackTrace(e));
		}
		CartItem carItem=null;
		 List<CartItem> itemList = getCartItemList(request);
		if (itemList!=null && itemList.size()>0) {
			for (CartItem cItem : itemList) {
				if (cItem.getId()==itemId) {
					cItem.setNum(cItem.getNum()+num);
					carItem=cItem;
					break;
				}
			}
		}
		
		KklResult pojo=null;
		try {
			pojo = KklResult.formatToPojo(doGetStr, TbItem.class);
		} catch (Exception e) {
			e.printStackTrace();
			return KklResult.build(500, ExceptionUtil.getStackTrace(e));
		}
		if (null==pojo) {
			System.out.println("ShoppingCarServiceImpl.addItem.formatToPojo fail,please check");
			return KklResult.build(500, "data convert exception"+itemId);
		}
		
		if (null==carItem) {
			carItem=new CartItem();
			if (pojo.getStatus()==200) {
				TbItem item=(TbItem) pojo.getData();
				carItem.setId(item.getId());
				carItem.setNum(num);
				carItem.setPrice(item.getPrice());
				carItem.setTitle(item.getTitle());
				carItem.setImage(item.getImage()==null?"":item.getImage().split(",")[0]);
			}
			itemList.add(carItem);
		}
		CookieUtils.setCookie(request, response, cartNameInCookie, JsonUtils.objectToJson(itemList), true);
		return KklResult.ok();
	}
	
	/**   
	 * @Title: getCartItemList   
	 * @Description: get item list from cookie   
	 * @param: @param request
	 * @param: @return      
	 * @return: List<CartItem>      
	 * @throws   
	 */ 
	private List<CartItem> getCartItemList(HttpServletRequest request){
		//get item list from cookie
		List<CartItem> list = new ArrayList<>();
		String cookieValueJson = CookieUtils.getCookieValue(request, cartNameInCookie, true);
		if (StringUtils.isBlank(cookieValueJson)) {
			System.out.println("no product inoformation in the cookie,please chose product");
			return list;
		}
		//convert this json to item list
		try {
			list = JsonUtils.jsonToList(cookieValueJson, CartItem.class);
		} catch (Exception e) {
			System.out.println("json to list exception please check,cart operation");
			e.printStackTrace();
			return list;
		}
		return list;
	}

	/**   
	 * <p>Title: getCartItemList</p>   
	 * <p>Description: get item list from cookie</p>   
	 * @param request
	 * @param response
	 * @return   
	 * @see com.supermarket.portal.service.ShoppingCarService#getCartItemList(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)   
	 */ 
	@Override
	public List<CartItem> getCartItemList(HttpServletRequest request, HttpServletResponse response) {
		List<CartItem> cartItemList = getCartItemList(request);
		return cartItemList;
	}

	/**   
	 * <p>Title: updateItemNum</p>   
	 * <p>Description: modify item quantity in cookie</p>   
	 * @param request
	 * @param response
	 * @param itemId
	 * @param num
	 * @return   
	 * @see com.supermarket.portal.service.ShoppingCarService#updateItemNum(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse, java.lang.Long, java.lang.Integer)   
	 */ 
	@Override
	public KklResult updateItemNum(HttpServletRequest request, HttpServletResponse response, Long itemId, Integer num) {
		List<CartItem> cartItemList = getCartItemList(request);
		for (CartItem cartItem : cartItemList) {
			if (itemId==cartItem.getId()) {
				cartItem.setNum(num);
			}
		}
		CookieUtils.setCookie(request, response, cartNameInCookie, JsonUtils.objectToJson(cartItemList),true);
		return KklResult.ok();
	}

	/**   
	 * <p>Title: deleteCartItemByItemId</p>   
	 * <p>Description: delete item by itemId in cart</p>   
	 * @param request
	 * @param response
	 * @param itemId
	 * @return   
	 * @see com.supermarket.portal.service.ShoppingCarService#deleteCartItemByItemId(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse, java.lang.Long)   
	 */ 
	@Override
	public KklResult deleteCartItemByItemId(HttpServletRequest request, HttpServletResponse response, Long itemId) {
		List<CartItem> cartItemList = getCartItemList(request);
		for (CartItem cartItem : cartItemList) {
			if (itemId==cartItem.getId()) {
				cartItemList.remove(cartItem);
				break;
			}
		}
		if (cartItemList!=null) {
			CookieUtils.setCookie(request, response, cartNameInCookie, JsonUtils.objectToJson(cartItemList), true);
		}
		return KklResult.ok();
	}
	
	

	
}
