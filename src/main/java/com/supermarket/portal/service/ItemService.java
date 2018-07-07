package com.supermarket.portal.service;

import com.supermarket.portal.pojo.ItemPo;

/**   
 * @ClassName: ItemService   
 * @Description: item information interface   
 * @author: KKL 
 * @date: 2018年7月6日 下午6:43:53      
 */  
public interface ItemService {

	
	/**   
	 * @Title: getItemBaseInfo   
	 * @Description: according to item query item base information   
	 * @param: @param itemId
	 * @param: @return      
	 * @return: TbItem      
	 * @throws   
	 */ 
	ItemPo getItemBaseInfo(long itemId);
	
	String getItemDescInformation(long itemId);
	
	String getItemParamInformation(long itemId);
}
