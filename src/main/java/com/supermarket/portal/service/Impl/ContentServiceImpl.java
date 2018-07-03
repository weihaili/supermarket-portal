package com.supermarket.portal.service.Impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.aspectj.weaver.NewConstructorTypeMunger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.supermarket.common.utils.HttpClientUtil;
import com.supermarket.common.utils.JsonUtils;
import com.supermarket.common.utils.KklResult;
import com.supermarket.pojo.TbContent;
import com.supermarket.portal.pojo.BigAdertisingSpacePojo;
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
		List<BigAdertisingSpacePojo> resultList=null;
		try {
			KklResult kklResult = KklResult.formatToList(result, TbContent.class);
			List<TbContent> list=(List<TbContent>) kklResult.getData();
			resultList=new ArrayList<>();
			for (TbContent tbContent : list) {
				BigAdertisingSpacePojo pojo=new BigAdertisingSpacePojo();
				pojo.setAlt(tbContent.getSubTitle());
				pojo.setHeight(240);
				pojo.setHeightB(240);
				pojo.sethref(tbContent.getUrl());
				pojo.setSrc(tbContent.getPic());
				pojo.setSrcB(tbContent.getPic2());
				pojo.setWidth(670);
				pojo.setWidthB(550);
				resultList.add(pojo);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return JsonUtils.objectToJson(resultList);
	}

}
