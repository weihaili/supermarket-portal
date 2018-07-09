package com.supermarket.portal.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.supermarket.common.utils.KklResult;
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
	
	@RequestMapping(value="/cart/add/{itemId}")
	public String addItemCart(HttpServletRequest request,HttpServletResponse response,
			@PathVariable Long itemId,@RequestParam(defaultValue="1") Integer num) {
		KklResult result = carService.addItem(request, response, itemId, num);
		if (result.getStatus()==200) {
			return "success";
		}
		return null;
	}

}
