package com.supermarket.portal.service.Impl;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.supermarket.common.utils.ExceptionUtil;
import com.supermarket.common.utils.HttpClientUtil;
import com.supermarket.common.utils.JsonUtils;
import com.supermarket.common.utils.KklResult;
import com.supermarket.portal.pojo.Order;
import com.supermarket.portal.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService {
	
	@Value("${ORDER_BASE_URL}")
	private String ORDER_BASE_URL;
	
	@Value("${ORDER_CREATE_URL}")
	private String ORDER_CREATE_URL;

	@Override
	public KklResult createNewOrder(Order order) {
		if (null==order) {
			System.out.println("The parameter received from the page is empty,please check");
			return KklResult.build(500, "The parameter received from the page is empty,please check");
		}
		
		String orderToJsonStr="";
		try {
			orderToJsonStr = JsonUtils.objectToJson(order);
		} catch (Exception e) {
			System.out.println("The parameter received from page convert to json exception,please check");
			return KklResult.build(500, ExceptionUtil.getStackTrace(e));
		}
		
		if (StringUtils.isBlank(orderToJsonStr)) {
			return KklResult.build(500, "The parameter received from page convert fail,please check");
		}
		
		String doPostJsonStr = HttpClientUtil.doPostJson(ORDER_BASE_URL+ORDER_CREATE_URL, orderToJsonStr);
		if (doPostJsonStr == null ||StringUtils.isBlank(doPostJsonStr)) {
			return KklResult.build(500, "Invoke order system generate orderId fail,please try again later");
		}
		
		KklResult result=null;
		try {
			result = KklResult.format(doPostJsonStr);
		} catch (Exception e) {
			System.out.println("conver kklResult exception,please check");
			return KklResult.build(500, ExceptionUtil.getStackTrace(e));
		}
		
		if (result==null) {
			return KklResult.build(500, "conver kklResult exception,please check");
		}
		
		String orderId="";
		if (result.getStatus()==200) {
			orderId = (String) result.getData();
		}
		return KklResult.ok(orderId);
	}


}
