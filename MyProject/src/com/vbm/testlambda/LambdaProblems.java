package com.vbm.testlambda;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class LambdaProblems {
	public static void main(String[] args) {

		// Print sum of squares of first 5 odd numbers
		Integer result = IntStream.iterate(1, i -> i + 2).limit(5).reduce(0, (x, y) -> x + (y * y));
		System.out.println(result);

		// Print sum of multiples of 3 or 5 in a range
		System.out.println(IntStream.range(1, 10).filter(number -> (number % 3 == 0 || number % 5 == 0)).reduce(0,
				(x, y) -> x + y));

		String[] teamNames = { "eng", "Australia", "aus", "india", "england", "zimbabwe" };

		// Sort based on characters
		System.out.println("Sort based on characters");
		Arrays.sort(teamNames);
		for (String team : teamNames) {
			System.out.println(team);
		}

		// Sort based on equality
		System.out.println("Sort based on equality");
		Arrays.sort(teamNames, String::compareToIgnoreCase);
		for (String team : teamNames) {
			System.out.println(team);
		}

		// Sort based on size
		System.out.println("Sort based on size");
		Arrays.sort(teamNames, (teamA, teamB) -> teamA.length() - teamB.length());
		for (String team : teamNames) {
			System.out.println(team);
		}

		List<String> myStrings = Arrays.asList(teamNames);

		// Convert back to String[]
		System.out.println("Convert to another string[]");
		String[] myNewTeam = myStrings.stream().map(String::new).toArray(String[]::new);
		for (String team : myNewTeam) {
			System.out.println(team);
		}
	}
}
