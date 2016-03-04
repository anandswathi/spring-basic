package com.yaliprowess.spring.session.basic.service.impl;

import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.io.IOUtils;

import com.yaliprowess.spring.session.basic.service.MessageReader;

public class MessageFileReaderImpl implements MessageReader{
	private StringBuilder builder = null;
	private InputStream in = null;

	public MessageFileReaderImpl(String fileName) {
		ClassLoader classLoader = getClass().getClassLoader();
		in = classLoader.getResourceAsStream(fileName);				
		builder = new StringBuilder();
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