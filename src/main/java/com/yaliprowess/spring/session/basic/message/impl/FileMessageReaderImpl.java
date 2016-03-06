package com.yaliprowess.spring.session.basic.message.impl;

import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.io.IOUtils;

import com.yaliprowess.spring.session.basic.message.MessageReaderService;

public class FileMessageReaderImpl implements MessageReaderService{
	private StringBuilder builder = null;
	private InputStream in = null;

	public FileMessageReaderImpl(String fileName) {
		ClassLoader classLoader = getClass().getClassLoader();
		in = classLoader.getResourceAsStream(fileName);						
	}
	//Call back method -hooks
	public void init(){
		builder = new StringBuilder();
	}
	public void destroy(){		
			builder = null;		
	}
	public String read() {		
		try {
			builder.append(IOUtils.toString(in));
		} catch (IOException e) {
			builder.append("Message recive error");
		}		
		return builder.toString();
	}
}