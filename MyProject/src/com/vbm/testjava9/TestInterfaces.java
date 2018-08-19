package com.vbm.testjava9;

public interface TestInterfaces {
	int interface_varible = 10;

	public static void callStatic() {
		System.out.println("TestInterfaces: displayStaticMethod");
	}

	void callNonStatic();

	void callNonStatic2();
	default void callDefaultMethod() {
		System.out.println("TestInterfaces: displayDefaultMethod");
	}
}
