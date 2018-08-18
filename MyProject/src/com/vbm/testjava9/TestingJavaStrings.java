package com.vbm.testjava9;

public class TestingJavaStrings {

	void formTheString(StringBuilder sb) {
		String str = new String("hello world");

		for (int i = 0; i < str.length(); i++) {
			System.out.println(str.charAt(i) + " "+str.indexOf(str.charAt(i)));
		}
		
		sb.append(str);
		System.out.println(sb.toString());
		System.out.println(str.replace('h', 'm'));
		System.out.println(str.toUpperCase());
		System.out.println(sb.capacity());
		System.out.println(sb.length());
	}

	public static void main(String[] args) {
		new TestingJavaStrings().formTheString(new StringBuilder("abcd"));		
	}
}
