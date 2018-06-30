package com.supermarket.portal.service.Impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.supermarket.common.utils.HttpClientUtil;
import com.supermarket.common.utils.JsonUtils;
import com.supermarket.common.utils.KklResult;
import com.supermarket.pojo.TbContent;
import com.supermarket.portal.service.ContentService;

@Service
public class ContentServiceImpl implements ContentService {
	
	@Value("${REST_BASIC_URL}")
	private String serverAddr;
	
	@Value("${REST_INDEX_AD_URL}")
	private String url;

	@Override
	public String getContentList() {
		String result = HttpClientUtil.doGet(serverAddr+url);
		List<Map> resultList=null;
		try {
			KklResult kklResult = KklResult.formatToList(result, TbContent.class);
			List<TbContent> list=(List<TbContent>) kklResult.getData();
			resultList=new ArrayList<>();
			for (TbContent tbContent : list) {
				Map map=new HashMap();
				map.put("srcB", tbContent.getPic());
				map.put("height", 240);
				map.put("alt", tbContent.getSubTitle());
				map.put("width", 670);
				map.put("srcB", tbContent.getPic2());
				map.put("heightB", 550);
				map.put("href", tbContent.getUrl());
				map.put("widthB", 240);
				resultList.add(map);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return JsonUtils.objectToJson(resultList);
	}

}
