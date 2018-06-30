package com.supermarket.portal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.supermarket.portal.service.ContentService;


/**
 * @author Admin
 * show index.jsp
 */
@Controller
public class IndexController {
	
	@Autowired
	private ContentService Service;
	
	@RequestMapping(value="/index")
	public String showIndexPage(Model model) {
		String adJsonStr = Service.getContentList();
		model.addAttribute("ad1", adJsonStr);
		return "index";
	}
	
	@RequestMapping(value="/httpClient/post",method=RequestMethod.POST)
	@ResponseBody
	public String testHttpClient() {
		return "Test post request";
	}
	
	@RequestMapping(value="/httpclient/postwithparam",method=RequestMethod.POST)
	@ResponseBody
	public String testHttpClientPostWithParam(String name,String password) {
		return "name="+name+"|| password="+password;
	}
}
