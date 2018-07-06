package com.supermarket.portal.service.Impl;

import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.supermarket.common.utils.HttpClientUtil;
import com.supermarket.common.utils.JsonUtils;
import com.supermarket.common.utils.KklResult;
import com.supermarket.pojo.TbItem;
import com.supermarket.pojo.TbItemDesc;
import com.supermarket.pojo.TbItemParamItem;
import com.supermarket.portal.service.ItemService;

/**   
 * @ClassName: ItemServiceImpl   
 * @Description: item information service   
 * @author: KKL 
 * @date: 2018年7月6日 下午6:45:33      
 */  
@Service
public class ItemServiceImpl implements ItemService {
	
	@Value("${REST_BASIC_URL}")
	private String REST_SERVICE;
	
	@Value("${ITEM_BASE_INFO_URL}")
	private String itemBaseInfoURL;
	
	@Value("${ITEM_DESC_INFO_URL}")
	private String itemDescURL;
	
	@Value("${ITEM_PARAM_INFO_URL}")
	private String itemParamURL;

	@Override
	public TbItem getItemBaseInfo(long itemId) {
		try {
			String doGetResultStr = HttpClientUtil.doGet(REST_SERVICE+itemBaseInfoURL+itemId);
			System.out.println("getItemBaseInfo"+doGetResultStr);
			if (!StringUtils.isBlank(doGetResultStr)) {
				KklResult kklResult = KklResult.formatToPojo(doGetResultStr, TbItem.class);
				if (kklResult.getStatus()==200) {
					TbItem item=(TbItem) kklResult.getData();
					return item;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public String getItemDescInformation(long itemId) {
		try {
			String doGetResultStr = HttpClientUtil.doGet(REST_SERVICE+itemDescURL+itemId);
			System.out.println("getItemDescInformation"+doGetResultStr);
			if (!StringUtils.isBlank(doGetResultStr)) {
				KklResult kklResult = KklResult.formatToPojo(doGetResultStr, TbItemDesc.class);
				if (kklResult.getStatus()==200) {
					TbItemDesc itemDesc=(TbItemDesc) kklResult.getData();
					return itemDesc.getItemDesc();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public String getItemParamInformation(long itemId) {
		try {
			String doGetResultStr = HttpClientUtil.doGet(REST_SERVICE+itemParamURL+itemId);
			System.out.println("getItemParamInformation"+doGetResultStr);
			if (!StringUtils.isBlank(doGetResultStr)) {
				KklResult resultPojo = KklResult.formatToPojo(doGetResultStr, TbItemParamItem.class);
				if (resultPojo.getStatus()==200) {
					TbItemParamItem itemParamItem=(TbItemParamItem) resultPojo.getData();
					String paramData=itemParamItem.getParamData();
					//生成html
					// 把规格参数json数据转换成java对象
					List<Map> jsonList = JsonUtils.jsonToList(paramData, Map.class);
					StringBuffer sb = new StringBuffer();
					sb.append("<table cellpadding=\"0\" cellspacing=\"1\" width=\"100%\" border=\"0\" class=\"Ptable\">\n");
					sb.append("    <tbody>\n");
					for(Map m1:jsonList) {
						sb.append("        <tr>\n");
						sb.append("            <th class=\"tdTitle\" colspan=\"2\">"+m1.get("group")+"</th>\n");
						sb.append("        </tr>\n");
						List<Map> list2 = (List<Map>) m1.get("params");
						for(Map m2:list2) {
							sb.append("        <tr>\n");
							sb.append("            <td class=\"tdTitle\">"+m2.get("k")+"</td>\n");
							sb.append("            <td>"+m2.get("v")+"</td>\n");
							sb.append("        </tr>\n");
						}
					}
					sb.append("    </tbody>\n");
					sb.append("</table>");
					//返回html片段
					return sb.toString();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	

}
