package com.supermarket.portal.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.supermarket.common.utils.KklResult;
import com.supermarket.portal.pojo.CartItem;
import com.supermarket.portal.service.ShoppingCarService;

/**   
 * @ClassName: CartController   
 * @Description: shopping cart manage   
 * @author: KKL 
 * @date: 2018年7月9日 下午9:54:51      
 */  
@Controller
public class CartController {
	
	@Autowired
	private ShoppingCarService carService;
	
	/**   
	 * @Title: addItemCart   
	 * @Description: add item to cart save in cookie  
	 * @param: @param request
	 * @param: @param response
	 * @param: @param itemId
	 * @param: @param num
	 * @param: @return      
	 * @return: String      
	 * @throws   
	 */ 
	@RequestMapping(value="/cart/add/{itemId}")
	public String addItemCart(HttpServletRequest request,HttpServletResponse response,
			@PathVariable Long itemId,@RequestParam(defaultValue="1") Integer num) {
		KklResult result = carService.addItem(request, response, itemId, num);
		if (result.getStatus()==200) {
			return "redirect:/cart/success.html";
		}
		return null;
	}
	
	/**   
	 * @Title: showAddCartSuccess   
	 * @Description: prevent refreshing browsers from adding repeatedly  
	 * @param: @return      
	 * @return: String      
	 * @throws   
	 */ 
	@RequestMapping(value="/cart/success")
	public String showAddCartSuccess() {
		return "cartSuccess";
	}
	
	/**   
	 * @Title: getCartItemListSettlement   
	 * @Description: show item list in cart   
	 * @param: @return      
	 * @return: String      
	 * @throws   
	 */ 
	@RequestMapping(value="/cart/cart")
	public String getCartItemListSettlement(HttpServletRequest request,HttpServletResponse response,Model model) {
		List<CartItem> cartItemList = carService.getCartItemList(request, response);
		model.addAttribute("cartList", cartItemList);
		return "cart";
	}
	
	/**   
	 * @Title: modifyQuantityAginDirect   
	 * @Description: modify item quantity 
	 * @param: @param itemId
	 * @param: @param num
	 * @param: @param request
	 * @param: @param response
	 * @param: @return      
	 * @return: String      
	 * @throws   
	 */ 
	@RequestMapping(value="/cart/update/num/{itemId}/{num}",method=RequestMethod.POST)
	public String modifyQuantityAginDirect(@PathVariable Long itemId,@PathVariable Integer num,HttpServletRequest request,HttpServletResponse response) {
		KklResult result = carService.updateItemNum(request, response, itemId, num);
		if (result.getStatus()==200) {
			return "redirect:/cart/cart.html";
		}
		return null;
	}
	
	/**   
	 * @Title: deleteCartItem   
	 * @Description: delete item by itemId in cart   
	 * @param: @param request
	 * @param: @param response
	 * @param: @param itemId
	 * @param: @return      
	 * @return: String      
	 * @throws   
	 */ 
	@RequestMapping(value="/cart/delete/{itemId}")
	public String deleteCartItem(HttpServletRequest request,HttpServletResponse response,@PathVariable Long itemId) {
		KklResult result = carService.deleteCartItemByItemId(request, response, itemId);
		if (result.getStatus()==200) {
			return "redirect:/cart/cart.html";
		}
		return null;
	}
	

}
