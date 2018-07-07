package com.supermarket.portal.controller;

import java.io.UnsupportedEncodingException;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.supermarket.common.pojo.SearchResult;
import com.supermarket.portal.service.SearchService;

@Controller
public class SearchController {
	
	@Autowired
	private SearchService service;
	
	/**
	 * 在q处可以设置默认查询参数
	 * @param queryStr
	 * @param page
	 * @return
	 */
	@RequestMapping("/search")
	public String search(@RequestParam("q")String queryStr,@RequestParam(defaultValue="1")Integer page,Model model) {
		try {
			if (!StringUtils.isBlank(queryStr)) {
				queryStr=new String(queryStr.getBytes("iso8859-1"),"UTF-8");
			}
			SearchResult searchResult = service.search(queryStr, page);
			//pass parameters to page
			model.addAttribute("query", queryStr);
			model.addAttribute("totalPages", searchResult.getPageCount());
			model.addAttribute("itemList", searchResult.getItemList());
			model.addAttribute("page", page);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return "search";
	}

}
