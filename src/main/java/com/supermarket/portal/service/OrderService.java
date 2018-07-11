package com.supermarket.portal.service;

import com.supermarket.common.utils.KklResult;
import com.supermarket.portal.pojo.Order;

public interface OrderService {
	
	/**   
	 * @Title: createNewOrder   
	 * @Description: create new order   
	 * @param: @param order
	 * @param: @param orderItem
	 * @param: @param orderShipping
	 * @param: @return      
	 * @return: KklResult      
	 * @throws   
	 */ 
	KklResult createNewOrder(Order order);

}
