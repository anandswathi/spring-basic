package com.yaliprowess.spring.session.basic.message.impl;

import com.yaliprowess.spring.session.basic.message.MessageReaderService;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Value;

import java.io.IOException;
import java.io.InputStream;

public class FileMessageReaderImpl implements MessageReaderService {

    private StringBuilder builder = null;

    @Value(value = "${message.file.name}")
    private String fileName = null;

    private ClassLoader classLoader = null;

    // Call back method -hooks
    public void init() {
        classLoader = getClass().getClassLoader();
        builder = new StringBuilder();
    }

    public void destroy() {
        builder = null;
    }

    public String read() {
        try {
            InputStream in = classLoader.getResourceAsStream(fileName);
            builder.append(IOUtils.toString(in));
        } catch (IOException e) {
            builder.append("Message recive error");
        }
        return builder.toString();
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

}