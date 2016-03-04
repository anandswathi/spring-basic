package com.yaliprowess.spring.session.basic.message.impl;

import java.util.Arrays;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.yaliprowess.spring.session.basic.message.MessageReaderService;

public class HTTPMessageReaderImpl implements MessageReaderService{
	
	private String restUrl = null; 	

	public String read() {			
		RestTemplate restTemplate = new RestTemplate();		
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);
		
		ResponseEntity<String> result = restTemplate.exchange(getRestUrl(), HttpMethod.GET, entity, String.class);
		
		return result.getBody();
	}
	
	public String getRestUrl() {
		return restUrl;
	}

	public void setRestUrl(String restUrl) {
		this.restUrl = restUrl;
	}
	
}
