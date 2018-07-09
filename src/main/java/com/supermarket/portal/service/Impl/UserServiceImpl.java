package com.supermarket.portal.service.Impl;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.supermarket.common.utils.HttpClientUtil;
import com.supermarket.common.utils.KklResult;
import com.supermarket.pojo.TbUser;
import com.supermarket.portal.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	@Value("${SSO_BASE_URL}")
	public String ssoBaseURL;
	
	@Value("${GET_USER_BY_TOKEN}")
	private String getUserInfoByTokenURL;
	
	@Value("${SSO_PAGE_LOGIN_URL}")
	public String ssoPageLoginURL;

	/**   
	 * <p>Title: getUserInfoByToken</p>   
	 * <p>Description: get user information by token</p>   
	 * @param token
	 * @return   
	 * @see com.supermarket.portal.service.UserService#getUserInfoByToken(java.lang.String)   
	 */ 
	@Override
	public TbUser getUserInfoByToken(String token) {
		if (StringUtils.isBlank(token)) {
			System.out.println("UserServiceImpl.getUserInfoByToken.token is null,please check");
			return null;
		}
		try {
			String doGetStr = HttpClientUtil.doGet(ssoBaseURL+getUserInfoByTokenURL+token);
			if (StringUtils.isBlank(doGetStr)) {
				System.out.println("UserServiceImpl.getUserInfoByToken.doGetStr is null please check");
				return null;
			}
			KklResult toPojo = KklResult.formatToPojo(doGetStr, TbUser.class);
			if (toPojo.getStatus()==200) {
				TbUser user=(TbUser) toPojo.getData();
				return user;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return null;
	}

}
