package com.thread.basic.runner;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

class SampleFileReaderThread extends Thread {

	@Override
	public void run() {
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
	}

}

public class ThreadMain {
	public static void main(String[] args) {

		SampleFileReaderThread thread1 = new SampleFileReaderThread(); //NEW
		SampleFileReaderThread thread2 = new SampleFileReaderThread();
		SampleFileReaderThread thread3 = new SampleFileReaderThread();

		thread1.start(); //Runnable
		thread2.start();
		thread3.start();
		
		//execution  // RUNNING
		//job completed //DEAD
	}
}
