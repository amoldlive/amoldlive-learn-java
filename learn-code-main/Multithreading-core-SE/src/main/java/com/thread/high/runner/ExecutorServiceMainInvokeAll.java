package com.thread.high.runner;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import com.thread.high.helper.log.LoggableProcessor;

public class ExecutorServiceMainInvokeAll {
	public static void main(String[] args) {
		testInvokeAll();

		// Executed all task
		// Returns result in List<Future<T>>
		// Returns result of all completed task

	}

	public static void testInvokeAll() {
		System.out.println("** Invoke All task started **");

		ExecutorService executorService = Executors.newSingleThreadExecutor();

		List<Callable<Boolean>> list = new ArrayList<Callable<Boolean>>();
		list.add(new LoggableProcessor());// 1
		list.add(new LoggableProcessor());// 2
		list.add(new LoggableProcessor());// 3
		list.add(new LoggableProcessor());// 4
		list.add(new LoggableProcessor());// 5

		try {
			List<Future<Boolean>> futureList = executorService.invokeAll(list);

			futureList.forEach(future -> {
				try {
					System.out.println("Future result : " + future.get());
				} catch (InterruptedException | ExecutionException e) {
					e.printStackTrace();
				}
			});

		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		executorService.shutdown();
		System.out.println("** Invoke All task completed **");
	}

}
