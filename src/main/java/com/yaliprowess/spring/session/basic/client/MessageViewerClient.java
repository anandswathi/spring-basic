package com.yaliprowess.spring.session.basic.client;

import com.yaliprowess.spring.session.basic.service.MessageReader;

public class MessageViewerClient {
	
	private MessageReader messageReader = null;
	private String fileName = "res/file.txt";

	public MessageViewerClient() {
		messageReader = new MessageReader(fileName);
	}	
	public String fetchData() {
		return messageReader.read();
	}
}