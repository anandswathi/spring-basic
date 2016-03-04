package com.yaliprowess.spring.session.basic.client;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.yaliprowess.spring.session.basic.service.ReaderService;

public class MessageViewerClient {
	
	private ApplicationContext ctx = null;	
	private ReaderService reader = null;	

	public MessageViewerClient() {
		ctx = new ClassPathXmlApplicationContext("application-context.xml");		
	}	
	public String fetchData() {
		reader = (ReaderService) ctx.getBean("readerService");
		return reader.fetchData();
	}
}