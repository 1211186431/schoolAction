package com.example.demo.util;


import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;


@Component
public class TestPing {
	/**
	 * 测试服务器是否可以连接
	 * @return
	 * @throws JSONException
	 */
	public String TestConfiguration() throws JSONException {       
        RestTemplate restTemplate = new RestTemplate();
		String url = "http://59.64.78.254:16224/ping";
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
		JSONObject jsonObj = new JSONObject();
		HttpEntity<String> entity = new HttpEntity<>(jsonObj.toString(), headers);
		String ping="suss";
		try {
			ResponseEntity<String> exchange = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
			exchange.getBody();
		}catch(ResourceAccessException e){
			ping="err";
        }
		
		return ping; 
	}
	
}

