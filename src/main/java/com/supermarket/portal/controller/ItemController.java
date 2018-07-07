package com.supermarket.portal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.supermarket.portal.pojo.ItemPo;
import com.supermarket.portal.service.ItemService;

/**   
 * @ClassName: ItemController   
 * @Description: item information display   
 * @author: KKL 
 * @date: 2018年7月6日 下午6:59:55      
 */  
@Controller
public class ItemController {
	
	@Autowired
	private ItemService itemService;

	@RequestMapping("/item/{itemId}")
	public String showItemInfo(@PathVariable Long itemId,Model model) {
		ItemPo item = itemService.getItemBaseInfo(itemId);
		model.addAttribute("item", item);
		return "item";
	}
	
	@RequestMapping(value="/item/desc/{itemId}",produces=MediaType.TEXT_HTML_VALUE+";charset=utf-8")
	@ResponseBody
	public String showItemDescInfo(@PathVariable Long itemId) {
		String result = itemService.getItemDescInformation(itemId);
		System.out.println("showItemDescInfo"+result);
		return result;
	}
	
	@RequestMapping(value="/item/param/{itemId}",produces=MediaType.TEXT_HTML_VALUE+";charset=utf-8")
	@ResponseBody
	public String showItemParamInfo(@PathVariable Long itemId) {
		String result = itemService.getItemParamInformation(itemId);
		System.out.println("showItemParamInfo"+result);
		return result;
	}
	
}
