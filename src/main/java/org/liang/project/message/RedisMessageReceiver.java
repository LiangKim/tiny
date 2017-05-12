package org.liang.project.message;

import java.util.concurrent.CountDownLatch;

import org.springframework.beans.factory.annotation.Autowired;

public class RedisMessageReceiver {
	private CountDownLatch latch;
	
	@Autowired
	public RedisMessageReceiver(CountDownLatch latch){
		this.latch = latch;
	}
	
	public void receiveMessage(String message){
		System.out.println("Receive <"+message+">");
		latch.countDown();
	}
}
