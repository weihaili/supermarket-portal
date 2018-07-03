package com.cn.supermarket.httpClient;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicHeader;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.http.HttpMethod;

public class HttpClientTest {
	
	String getUrl="http://localhost:8081/rest/content/list/89";
	String postUrl="http://www.baidu.com";
	
	private CloseableHttpClient httpClient;
	@Before
	public void Init() {
		httpClient=HttpClients.createDefault();
	}
	@After
	public void close() {
		try {
			httpClient.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void doPostWithParam() {
		HttpPost post=new HttpPost("http://localhost:8082/httpclient/postwithparam.do");
		try {   
			List<NameValuePair> kvList=new ArrayList<>();
			kvList.add(new BasicNameValuePair("name", "托洛普"));
			kvList.add(new BasicNameValuePair("password", "123456"));
			StringEntity postEntity=new UrlEncodedFormEntity(kvList,"utf-8");
			post.setEntity(postEntity);
			//set request head character set
			post.setHeader(new BasicHeader("Content-Type", "application/x-www-form-urlencoded; charset=utf-8"));
			
			//set expect response character set
			post.setHeader(new BasicHeader("Accept", "text/plain;charset=utf-8"));
			
			CloseableHttpResponse response = httpClient.execute(post);
			int code = response.getStatusLine().getStatusCode();
			System.out.println(code);
			HttpEntity entity = response.getEntity();
			String str = EntityUtils.toString(entity, "UTF-8");
			System.out.println(str);
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * attention: response state code 406
	 * the reason:1.frame request response html style data,we finally response json style data
	 *            frame unable convert json to html,so occur 406 code
	 *            2.check jackson.jar exist
	 * solution:project in web.xml configuration add intercept path suffix species
	 */
	@Test
	public void doPost2() {
		HttpPost post=new HttpPost("http://localhost:8082/httpClient/post.do");
		try {
			CloseableHttpResponse response = httpClient.execute(post);
			int code = response.getStatusLine().getStatusCode();
			System.out.println(code);
			HttpEntity entity = response.getEntity();
			String str = EntityUtils.toString(entity, "UTF-8");
			System.out.println(str);
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	@Test
	public void doGetWithParam() {
		URIBuilder uriBuilder;
		try { 
			uriBuilder = new URIBuilder("http://www.sogou.com/web");
			uriBuilder.addParameter("query", "花千骨");
			HttpGet get=new HttpGet(uriBuilder.build());
			CloseableHttpResponse response = httpClient.execute(get);
			int code = response.getStatusLine().getStatusCode();
			System.out.println(code);
			HttpEntity entity = response.getEntity();
			String str = EntityUtils.toString(entity, "uTF-8");
			System.out.println(str);
			response.close();
		} catch (URISyntaxException | IOException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void doPost() {
		HttpPost post=new HttpPost(postUrl);
		try {
			CloseableHttpResponse response = httpClient.execute(post);
			HttpEntity entity = response.getEntity();
			String str = EntityUtils.toString(entity, "utf-8");
			System.out.println(str);
			int code = response.getStatusLine().getStatusCode();
			System.out.println(code);
			response.close();
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void doGet() {
		//1. create httpClient object
		CloseableHttpClient httpClient=HttpClients.createDefault();
		//2. create get object
		HttpGet get= new HttpGet(getUrl);
		//3. execute request
		try {
			CloseableHttpResponse response = httpClient.execute(get);
			//4. obtain response
			HttpEntity entity = response.getEntity();
			String string = EntityUtils.toString(entity);
			System.out.println(string);
			int code = response.getStatusLine().getStatusCode();
			System.out.println(code);
			//5. close httpClient
			response.close();
			httpClient.close();
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
