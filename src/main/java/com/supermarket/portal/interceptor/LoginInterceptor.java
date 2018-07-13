package com.supermarket.portal.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.supermarket.common.utils.CookieUtils;
import com.supermarket.pojo.TbUser;
import com.supermarket.portal.service.Impl.UserServiceImpl;

public class LoginInterceptor implements HandlerInterceptor {
	
	@Autowired
	private UserServiceImpl userService;

	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		//execute this logic after return modelAndView 
	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {
		//execute this logic after handle execute but do not return modelAndView

	}

	/**   
	 * <p>Title: preHandle</p>   
	 * <p>Description: 1. determine if the user is logged in before handle execute 
	 * 				   2. return value determine if this handler is execute
	 *      1. determine if the user is  logged,get token from cookie
	 *      2. invoke SSO service exchange user information by the token
	 *      3. if do not in exchange for user information,jump to login page,pass the page url requested by the user as a parameter to the login page,then return false.
	 *      4. if in exchange for user information ,return true.
	 * </p>   
	 * @param arg0
	 * @param arg1
	 * @param arg2
	 * @return
	 * @throws Exception   
	 * @see org.springframework.web.servlet.HandlerInterceptor#preHandle(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse, java.lang.Object)   
	 */ 
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object arg2) throws Exception {
		String token = CookieUtils.getCookieValue(request, "TT_TOKEN");
		TbUser tbUser = userService.getUserInfoByToken(token);
		if (null==tbUser) {
			response.sendRedirect(userService.ssoBaseURL+userService.ssoPageLoginURL+"?redirect="+request.getRequestURL());
			return false;
		}
		request.setAttribute("user", tbUser);
		return true;
	}

}
