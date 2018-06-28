package com.supermarket.portal.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Admin
 * show index.jsp
 */
@Controller
public class IndexController {
	@RequestMapping(value="/index")
	public String showIndexPage() {
		return "index";
	}
}
