package com.vbm.testjava9;

public class TestingJavaStaticFinalVars {
	static final int x;
	final int k;

	TestingJavaStaticFinalVars() {
		k = 30;
	}

	static {
		x = 20;
	}

	public static void main(String[] args) {
		int z = new TestingJavaStaticFinalVars().k;
		System.out.println("x = " + x);
		System.out.println("z = " + z);
	}
}
