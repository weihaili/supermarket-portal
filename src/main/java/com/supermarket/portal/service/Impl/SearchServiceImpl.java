package com.supermarket.portal.service.Impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.supermarket.common.pojo.SearchResult;
import com.supermarket.common.utils.HttpClientUtil;
import com.supermarket.common.utils.KklResult;
import com.supermarket.portal.service.SearchService;
@Service
public class SearchServiceImpl implements SearchService {
	
	@Value("${SEARCH_BASE_URL}")
	private String baseURL;
	
	@Override
	public SearchResult search(String queryStr, int page) {
		//invoke supermarket-search service 
		//set query parameter
		Map<String, String> param = new HashMap<String, String>();
		param.put("q", queryStr);
		param.put("page", page+"");
		//param.put("rews", rows+"");
		SearchResult searchResult=null;
		try {
			String serverResultStr = HttpClientUtil.doGet(baseURL, param);
			System.out.println("SearchServiceImpl.search"+serverResultStr);
			KklResult kklResult = KklResult.formatToPojo(serverResultStr, SearchResult.class);
			if (kklResult.getStatus()==200) {
				searchResult = (SearchResult) kklResult.getData();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return searchResult;
	}

}
