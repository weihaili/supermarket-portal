package com.supermarket.portal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.supermarket.pojo.TbItem;
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
		TbItem item = itemService.getItemBaseInfo(itemId);
		model.addAttribute("item", item);
		return "item";
	}
	
	@RequestMapping("/item/desc/{itemId}")
	@ResponseBody
	public String showItemDescInfo(@PathVariable Long itemId) {
		String result = itemService.getItemDescInformation(itemId);
		return result;
	}
	
	@RequestMapping(value="/item/param/{itemId}")
	@ResponseBody
	public String showItemParamInfo(@PathVariable Long itemId) {
		String result = itemService.getItemParamInformation(itemId);
		return result;
	}
	
}
