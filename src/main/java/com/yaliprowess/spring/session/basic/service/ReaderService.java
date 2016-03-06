package com.yaliprowess.spring.session.basic.service;

import com.yaliprowess.spring.session.basic.message.MessageReaderService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class ReaderService {

    private MessageReaderService reader = null;

    public MessageReaderService getReader() {
        return reader;
    }

    @Autowired
    // @Qualifier(value = "httpMessageReader")
    @Qualifier(value = "fileMessageReader")
    public void setReader(MessageReaderService reader) {
        this.reader = reader;
    }

    public String fetchData() {
        return reader.read();
    }
}