package com.thread.high.helper.log;

import java.util.concurrent.Callable;

public class LoggableProcessor implements Callable<Boolean> {
	
	
	@Override
	public Boolean call() throws Exception {
		System.out.println(Thread.currentThread().getName() +" -> logginng data ");
		return true;
	}
}
