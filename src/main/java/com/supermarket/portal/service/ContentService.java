package com.supermarket.portal.service;

import com.supermarket.common.utils.KklResult;

public interface ContentService {
	
	String getContentList();

	/**
	 * @param token    
	 * @Title: secureLogout   
	 * @Description: secure logout
	 * @param: @return      
	 * @return: KklResult      
	 * @throws   
	 */ 
	KklResult secureLogout(String token);
}
