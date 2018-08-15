package com.vbm.testlambda;

import java.util.function.IntPredicate;
import java.util.function.Predicate;
import java.util.stream.IntStream;

public class LambdaProblems {
	public static void main(String[] args) {

		Integer result = IntStream.iterate(1,i -> i + 2)
				 .limit(5)
				 .reduce(0,(x,y)-> x+(y*y));
		System.out.println(result);

		
		System.out.println(IntStream.range(1, 10)
		         .filter(n -> n%3==0 || n%5==0)
		         .reduce(0,(x,y)-> x+y));
		         //.forEach(System.out::println);
		         
		
	}
}
