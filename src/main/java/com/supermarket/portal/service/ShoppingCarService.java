package com.supermarket.portal.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.supermarket.common.utils.KklResult;

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

}
