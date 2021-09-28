package com.thread.high.runner;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/*
 * Executor
 * ExecutorService
 * 
 * */
public class ExecutorMain {
	public static void main(String[] args) {
		
		
		Runnable runnable = () -> {
			String fileName = "E:\\Workspace\\Logical Development V2\\amoldlive-learn-java\\learn-code-main\\Multithreading-core-SE\\src\\main\\resources\\sample.txt";
			String line = "";

			try (BufferedReader br = new BufferedReader(new FileReader(new File(fileName)))) {

				while ((line = br.readLine()) != null) {
					System.out.println(Thread.currentThread().getName() + "  - reading line - " + line);
				}

			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}

		};
		
		//Executor - interface | Executors - factory class
		Executor executor=Executors.newSingleThreadExecutor();
		executor.execute(runnable); // take only runnable as arg
		
	}
}
