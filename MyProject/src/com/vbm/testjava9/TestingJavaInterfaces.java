package com.vbm.testjava9;

public class TestingJavaInterfaces implements TestInterfaces, AnotherTestInterface {
	public void callNonStatic() {
		System.out.println("TestingJavaInterfaces: callNonStatic");
	}

	public void callDefaultMethod() {
		AnotherTestInterface.super.callDefaultMethod();
	}

	@Override
	public void callNonStatic2() {
		// TODO Auto-generated method stub

	}

	public static void main(String[] args) {
		new TestingJavaInterfaces().callNonStatic();
		new TestingJavaInterfaces().callDefaultMethod();

		TestInterfaces myNewInterface = new TestingJavaInterfaces() {

			@Override
			public void callNonStatic() {
				// TODO Auto-generated method stub

			}

			@Override
			public void callNonStatic2() {
				// TODO Auto-generated method stub

			}
		};
		
		myNewInterface.callDefaultMethod();
	}
}
