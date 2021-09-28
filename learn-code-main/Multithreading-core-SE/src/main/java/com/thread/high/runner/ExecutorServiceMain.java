package com.thread.high.runner;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import com.thread.high.helper.user.UserDao;
import com.thread.high.helper.user.UserProcessor;

public class ExecutorServiceMain {
	public static void main(String[] args) {

		String fileName = "E:\\Workspace\\Logical Development V2\\amoldlive-learn-java\\learn-code-main\\Multithreading-core-SE\\src\\main\\resources\\new_users.txt";
		List<String> recordList = getRecordsFromFile(fileName);
		System.out.println("Records : " + recordList);

		UserDao userDao = new UserDao();
		userDao.cleanTable(); // trucating table for fresh data

		/* Single thread will be created and execute the task */
		// ExecutorService executorService = Executors.newSingleThreadExecutor();

		/* 3 threads will be created and exxecute the task */
		ExecutorService executorService = Executors.newFixedThreadPool(3);

		recordList.forEach(record -> {
			// submit -> takes runnable & collable as arg
			Future<Integer> future = executorService.submit(new UserProcessor(record, userDao));
			try {
				System.out.println("Final Result : " + future.get());
			} catch (InterruptedException e) {
				e.printStackTrace();
			} catch (ExecutionException e) {
				e.printStackTrace();
			}
		});

		executorService.shutdown();
		System.out.println("Main execution completed : ");

	}

	public static List<String> getRecordsFromFile(String fileName) {

		List<String> recordList = new ArrayList<>();
		String line = "";
		try (BufferedReader br = new BufferedReader(new FileReader(new File(fileName)))) {

			while ((line = br.readLine()) != null) {
				recordList.add(line);
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return recordList;
	}
}
