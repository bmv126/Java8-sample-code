package com.vbm.thread;

import java.util.concurrent.CountDownLatch;

public class ThreadCountDownLatchExample {
	CountDownLatch latch;
	public ThreadCountDownLatchExample(CountDownLatch latch) {
		this.latch = latch;
	}

	public void testCountDown() {
		
		Thread t1 = new Thread() {
			public void run() {
				System.out.println("executing countDown for thread"+Thread.currentThread().getName());
				latch.countDown();
				System.out.println("finished executing countDown for thread"+Thread.currentThread().getName());
			}
		};
		
		Thread t2 = new Thread() {
			public void run() {
				System.out.println("executing countDown for thread"+Thread.currentThread().getName());
				latch.countDown();
				System.out.println("finished executing countDown for thread"+Thread.currentThread().getName());
			}
		};
		
		Thread t3 = new Thread() {
			public void run() {
				System.out.println("executing countDown for thread"+Thread.currentThread().getName());
				latch.countDown();
				System.out.println("finished executing countDown for thread"+Thread.currentThread().getName());
				//latch.countDown();
			}
		};
		t1.start();
		t2.start();
		t3.start();
	}
	public static void main(String[] args) {
		CountDownLatch latch = new CountDownLatch(3);
		ThreadCountDownLatchExample myInstance = new ThreadCountDownLatchExample(latch);
		myInstance.testCountDown();
		try {
			myInstance.latch.await();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(myInstance.latch.getCount());
		System.out.println("finished main thread");
	}
}
