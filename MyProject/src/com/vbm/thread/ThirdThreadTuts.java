package com.vbm.thread;

public class ThirdThreadTuts implements Runnable {
	int count = 0;
	Object myLock = new Object();

	public static void main(String[] args) {
		ThirdThreadTuts myInstance = new ThirdThreadTuts();

		Thread t1 = new Thread(myInstance);
		Thread t2 = new Thread(myInstance);
		t1.start();
		t2.start();
		System.out.println("end of main");
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			System.out.println("end of thread process");
		}
	}

	@Override
	public void run() {
		synchronized (myLock) {
			try {
				Thread.sleep(1000);
				for (int i = 0; i < 100000; i++)
					count++;
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		printCount();

	}

	private void printCount() {
		System.out.println("count = " + count);
	}

}
