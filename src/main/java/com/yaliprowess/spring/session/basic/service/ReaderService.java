package com.yaliprowess.spring.session.basic.service;

import com.yaliprowess.spring.session.basic.message.MessageReaderService;

public class ReaderService {
	private MessageReaderService reader = null;

	public ReaderService(MessageReaderService reader) {
		this.reader = reader;
	}

	public String fetchData() {
		return reader.read();
	}
}