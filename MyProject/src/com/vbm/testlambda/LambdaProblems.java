package com.vbm.testlambda;

import java.util.stream.IntStream;

public class LambdaProblems {
	public static void main(String[] args) {

		//Print sum of squares of first 5 odd numbers
		Integer result = IntStream.iterate(1,i -> i + 2)
				 .limit(5)
				 .reduce(0,(x,y)-> x+(y*y));
		System.out.println(result);
	}
}
