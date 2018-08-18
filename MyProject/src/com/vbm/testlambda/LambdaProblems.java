package com.vbm.testlambda;

import java.security.Identity;
import java.util.function.IntPredicate;
import java.util.function.Predicate;
import java.util.stream.IntStream;

public class LambdaProblems {
	public static void main(String[] args) {

		//Print sum of squares of first 5 odd numbers
		Integer result = IntStream.iterate(1,i -> i + 2)
				 .limit(5)
				 .reduce(0,(x,y)-> x+(y*y));
		System.out.println(result);

		//Print sum of multiples of 3 or 5 in a range
		System.out.println(IntStream.range(1, 10)
		         .filter(number -> (number%3==0 || number%5==0))
		         .reduce(0,(x,y)-> x+y));	

	}
}
