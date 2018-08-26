package com.vbm.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class FourthThreadTuts implements Runnable {
	int count = 0;
	Semaphore sem = new Semaphore(1);

	public static void main(String[] args) {
		FourthThreadTuts myInstance = new FourthThreadTuts();
		ExecutorService executorService = Executors.newFixedThreadPool(3);
		for (int i = 0; i < 3; i++)
			executorService.submit(myInstance);
		executorService.shutdown();
		try {
			executorService.awaitTermination(1, TimeUnit.DAYS);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			System.out.println("all threads stopped");
		}
	}

	@Override
	public void run() {
		try {
			sem.acquire();
			for (int i = 0; i < 100; i++) {
				count++;
			}
			System.out.println("sum of count is " + count);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			sem.release();
		}
	}
}
