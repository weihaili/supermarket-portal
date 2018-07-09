package com.supermarket.portal.service;

import com.supermarket.pojo.TbUser;

public interface UserService {
	
	/**   
	 * @Title: getUserInfoByToken   
	 * @Description: get user information by token   
	 * @param: @param token
	 * @param: @return      
	 * @return: TbUser      
	 * @throws   
	 */ 
	TbUser getUserInfoByToken(String token);

}
