package com.supermarket.portal.service;

import com.supermarket.common.pojo.SearchResult;

public interface SearchService {
	
	SearchResult search(String queryStr,int page) ;

}
