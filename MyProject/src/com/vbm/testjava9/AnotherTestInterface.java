package com.vbm.testjava9;

public interface AnotherTestInterface {
	default void callDefaultMethod() {
		System.out.println("AnotherTestInterface: displayDefaultMethod");
	}
}
