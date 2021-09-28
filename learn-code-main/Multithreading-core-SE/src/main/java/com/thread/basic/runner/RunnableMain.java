package com.thread.basic.runner;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class RunnableMain {
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

		Thread t1=new Thread(runnable);//NEW
		Thread t2=new Thread(runnable);
		Thread t3=new Thread(runnable);
	
		t1.start();//Runnable
		t2.start();
		t3.start();
		
		//execution  // Running
		//job completed //DEAD
		
	}
}
