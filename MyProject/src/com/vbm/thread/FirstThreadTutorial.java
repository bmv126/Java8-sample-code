package com.vbm.thread;

public class FirstThreadTutorial {

	static int classVar = 0;

	static synchronized void incrClassVar() {
		for (int i = 0; i < 1000; i++)
			classVar++;
	}

	public static void main(String[] args) {

		Thread t1 = new Thread(new Runnable() {

			@Override
			public void run() {
				incrClassVar();
			}
		});

		Thread t2 = new Thread(new Runnable() {
			@Override
			public void run() {
				incrClassVar();
			}
		});

		Thread t3 = new Thread(() -> incrClassVar());

		t1.start();
		t2.start();
		t3.start();

		try {
			t1.join();
			t2.join();
			t3.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(" classVar value is " + classVar);
	}
}
