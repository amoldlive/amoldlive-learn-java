package com.thread.high.runner;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

import com.thread.high.helper.log.LoggableProcessor;

/*Executor API uses a default Thread factory to create
threads for the application
*/
/*
Custom Thread factory created to give custom names,
priorities, and decide daemon status of each thread
*/
class MyThreadFactory implements ThreadFactory {

	static int counter = 0;

	@Override
	public Thread newThread(Runnable r) {
		Thread thread = new Thread(r);
		thread.setName("Current Thread : " + "T->" + (++counter));
		return thread;
	}

}

public class ThreadFactoryMain {
	public static void main(String[] args) throws InterruptedException {

		// using custom thread fractory for custom thread properties
		ExecutorService executorService = Executors.newFixedThreadPool(3, new MyThreadFactory());

		for (int i = 0; i < 6; i++) {
			Thread.sleep(2000);
			executorService.submit(new LoggableProcessor());
		}

	}
}
