package com.thread.high.runner;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import com.thread.high.helper.log.LoggableProcessor;

public class ExecutorServiceMainInvokeAny {
	public static void main(String[] args) {
		testInvokeAny();
		
		// Executed any number of task from input tasks
		// Returns result in T
		// Returns result of only first successful operation
		// can be used in messaging system where we want to push multiple message for delivery assurance
	}

	public static void testInvokeAny() {
		System.out.println("** Invoke Any task started **");

		ExecutorService executorService = Executors.newSingleThreadExecutor();

		List<Callable<Boolean>> list = new ArrayList<Callable<Boolean>>();
		list.add(new LoggableProcessor());// 1
		list.add(new LoggableProcessor());// 2
		list.add(new LoggableProcessor());// 3
		list.add(new LoggableProcessor());// 4
		list.add(new LoggableProcessor());// 5

		try {
			Boolean future = executorService.invokeAny(list);
			System.out.println("Future result : " + future);

		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		} 

		//shutdown service and finish all pending task | no new task accepted
		executorService.shutdown();
		
		try {
			executorService.awaitTermination(30, TimeUnit.SECONDS);
		} catch (InterruptedException e) {
			//shutdown service immediately  | returns list of pending task from queue | finishes processing tasks | no new task accepted 
			executorService.shutdownNow();
			e.printStackTrace();
		}
		
		System.out.println("** Invoke Any task completed **");
	}

}
