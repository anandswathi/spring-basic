package com.yaliprowess.spring.session.basic.service;

import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.io.IOUtils;

public class MessageReader {
	private StringBuilder builder = null;
	private InputStream in = null;

	public MessageReader(String fileName) {
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