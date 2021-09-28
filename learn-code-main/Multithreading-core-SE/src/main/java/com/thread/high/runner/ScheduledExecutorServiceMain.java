package com.thread.high.runner;

import java.io.File;
import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/*Task : Read file names from folders */
class ServerLogUtil implements Runnable {

	@Override
	public void run() {

		String folder = "E:\\Workspace\\Logical Development V2\\amoldlive-learn-java\\learn-code-main\\Multithreading-core-SE\\src\\main\\resources\\server logs\\";
		File folderPath = new File(folder);

		if (folderPath.exists()) {
			File[] listFiles = folderPath.listFiles();

			for (File file : listFiles) {
				System.out.println(file.getName());
			}

		} else {
			System.out.println("Not finding folder path");

		}

	}

}

public class ScheduledExecutorServiceMain {
	public static void main(String[] args) {
		// Executors.newSingleThreadScheduledExecutor();
		// Executors.newScheduledThreadPool(10);
		System.out.println("Scheduling Task started");

		ScheduledExecutorService scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();

		/* executed after 5 seconds */
		// scheduledExecutorService.schedule(new ServerLogUtil(), 5, TimeUnit.SECONDS);


		/*executes after 5 seconds | repeat process after 3 seconds*/
		//scheduledExecutorService.scheduleAtFixedRate(new ServerLogUtil(), 5, 3, TimeUnit.SECONDS);
		
		
		/*executes after 5 seconds | repeat process after ( time to finish the task + 3) seconds*/
		scheduledExecutorService.scheduleWithFixedDelay(new ServerLogUtil(), 5, 3, TimeUnit.SECONDS);
		
		
		//scheduledExecutorService.shutdown();
		
		
	}

}
