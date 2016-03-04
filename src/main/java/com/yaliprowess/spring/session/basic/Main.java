package com.yaliprowess.spring.session.basic;

import com.yaliprowess.spring.session.basic.client.MessageViewerClient;

public class Main {
	public static void main(String[] args) {
		MessageViewerClient messageViewer = new MessageViewerClient();
		System.out.println("Message : " + messageViewer.fetchData());
	}
}
