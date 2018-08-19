package com.vbm.testjava9;

public class TestingJavaPassByValue {
	int x;

	public TestingJavaPassByValue() {
		// TODO Auto-generated constructor stub
		x = 50;
	}

	public void changeValueOfX(TestingJavaPassByValue e) {
		e.x = 20; // This will modify the value of passByValue pbject passed
		e = new TestingJavaPassByValue();
		e.displayValueOfX(); // Prints 50
		System.out.println("==================");
	}

	public void displayValueOfX() {
		System.out.println(this);
		System.out.println("x = " + this.x);
	}

	public static void main(String[] args) {
		TestingJavaPassByValue passByValue = new TestingJavaPassByValue();
		passByValue.changeValueOfX(passByValue);
		passByValue.displayValueOfX(); // Prints 20
	}
}
