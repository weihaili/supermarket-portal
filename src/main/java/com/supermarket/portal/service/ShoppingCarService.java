package com.supermarket.portal.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.supermarket.common.utils.KklResult;
import com.supermarket.portal.pojo.CartItem;

public interface ShoppingCarService {
	
	/**   
	 * @Title: addItem   
	 * @Description: add shopping car item   
	 * @param: @param itemId
	 * @param: @param num
	 * @param: @return      
	 * @return: KklResult      
	 * @throws   
	 */ 
	KklResult addItem(HttpServletRequest request,HttpServletResponse response,long itemId,int num);

	/**   
	 * @Title: getCartItemList   
	 * @Description: get item list from cookie   
	 * @param: @param request
	 * @param: @param response
	 * @param: @return      
	 * @return: List<CartItem>      
	 * @throws   
	 */ 
	List<CartItem> getCartItemList(HttpServletRequest request,HttpServletResponse response);

	/**   
	 * @Title: updateItemNum   
	 * @Description: modify item quantity   
	 * @param: @param request
	 * @param: @param response
	 * @param: @param itemId
	 * @param: @param num
	 * @param: @return      
	 * @return: KklResult      
	 * @throws   
	 */ 
	KklResult updateItemNum(HttpServletRequest request, HttpServletResponse response, Long itemId, Integer num);

	/**   
	 * @Title: deleteCartItemByItemId   
	 * @Description: delete item by itemId in cart   
	 * @param: @param request
	 * @param: @param response
	 * @param: @param itemId
	 * @param: @return      
	 * @return: KklResult      
	 * @throws   
	 */ 
	KklResult deleteCartItemByItemId(HttpServletRequest request, HttpServletResponse response, Long itemId);
	
}
