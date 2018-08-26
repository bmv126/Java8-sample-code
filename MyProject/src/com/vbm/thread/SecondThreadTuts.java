package com.vbm.thread;

public class SecondThreadTuts {
	int count = 0;

	void incrValueOfCount() {
		System.out.println("ThreadName = " + Thread.currentThread().getName());
		
		synchronized (this) {
			for (int i = 0; i < 10000; i++)
				count++;
		}

	}

	private void printValueOfCount() {
		System.out.println("value of count = " + count);
	}

	private void doWork() {
		Thread t1 = new Thread(() -> incrValueOfCount());
		Thread t2 = new Thread(() -> incrValueOfCount());
		t1.start();
		t2.start();
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {
		SecondThreadTuts myInstance = new SecondThreadTuts();
		myInstance.doWork();
		myInstance.printValueOfCount();
	}

}
