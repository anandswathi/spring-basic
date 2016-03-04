package com.yaliprowess.spring.session.basic.client;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.yaliprowess.spring.session.basic.service.MessageReader;
import com.yaliprowess.spring.session.basic.service.impl.MessageFileReaderImpl;

public class MessageViewerClient {
	
	private ApplicationContext ctx = null;	
	private MessageReader messageReader = null;	

	public MessageViewerClient() {
		ctx = new ClassPathXmlApplicationContext("application-context.xml");		
	}	
	public String fetchData() {
		messageReader = (MessageFileReaderImpl) ctx.getBean("messageReader");
		return messageReader.read();
	}
}