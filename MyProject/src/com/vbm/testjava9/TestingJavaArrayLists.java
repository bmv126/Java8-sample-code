package com.vbm.testjava9;

import java.util.ArrayList;
import java.util.Collections;

public class TestingJavaArrayLists {
	public static void main(String[] args) {
		ArrayList<Integer> myIntegerList = new ArrayList<>();
		myIntegerList.add(20);
		myIntegerList.add(20);
		myIntegerList.add(22);
		myIntegerList.add(24);

		System.out.println(myIntegerList.size());
		System.out.println(myIntegerList.get(0).equals(myIntegerList.get(1)));
		System.out.println(myIntegerList.get(0) == myIntegerList.get(1));

		for (Integer integer : myIntegerList) {
			System.out.println(integer);
		}

		ArrayList<Integer> myNewIntegerList = new ArrayList<>();
		myNewIntegerList = myIntegerList;

		myNewIntegerList.stream().forEach(System.out::println);
		myNewIntegerList.set(1, 25);
		System.out.println("=====================");
		myNewIntegerList.stream().forEach(System.out::println);
		System.out.println("=====================");
		myIntegerList.stream().forEach(System.out::println);

		ArrayList<Integer> myCopyIntegerList = new ArrayList<Integer>(myIntegerList);
		myCopyIntegerList.set(1, 33);

		System.out.println("====== For new copy ======");
		myCopyIntegerList.stream().forEach(System.out::println);
		System.out.println("=====================");
		myIntegerList.stream().forEach(System.out::println);

		System.out.println("====== After sorting ======");
		Collections.sort(myCopyIntegerList);
		myCopyIntegerList.stream().forEach(System.out::println);

		myIntegerList.add(100);
		System.out.println("====== After sorting myIntegerList ======");
		Collections.sort(myIntegerList);
		myIntegerList.stream().forEach(System.out::println);
		myIntegerList.stream().forEach(System.out::println);

	}
}
