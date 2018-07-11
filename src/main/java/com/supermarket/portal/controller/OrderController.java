package com.supermarket.portal.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.supermarket.common.utils.KklResult;
import com.supermarket.portal.pojo.CartItem;
import com.supermarket.portal.pojo.Order;
import com.supermarket.portal.service.OrderService;
import com.supermarket.portal.service.ShoppingCarService;

/**   
 * @ClassName: OrderController   
 * @Description: order manager
 * @author: KKL 
 * @date: 2018年7月11日 下午5:39:27      
 */  
@Controller
public class OrderController {
	
	@Autowired
	private ShoppingCarService cartService;
	
	@Autowired
	private OrderService orderService;
	
	/**   
	 * @Title: showOrderConfirmPage   
	 * @Description: open order confirm page   
	 * @param: @return      
	 * @return: String      
	 * @throws   
	 */ 
	@RequestMapping("/order/order-cart")
	public String showOrderConfirmPage(HttpServletRequest request,HttpServletResponse response
			,Model model) {
		List<CartItem> cartItemList = cartService.getCartItemList(request, response);
		model.addAttribute("cartList", cartItemList);
		return "order-cart";
	}
	
	@RequestMapping(value="/order/create",method=RequestMethod.POST)
	public String createNewOrder(Order order,Model model) {
		try {
			KklResult result = orderService.createNewOrder(order);
			String orderId = (String) result.getData();
			model.addAttribute("orderId", orderId);
			model.addAttribute("payment", order.getPayment());
			model.addAttribute("date", new DateTime().plusDays(3).toString("yyyy-MM-dd"));
			
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("message", "Request to try again later in system maintenance");
			return "error/exception";
		}
		
		return "success";
	}
	
	

}
