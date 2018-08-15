package com.vbm.pecs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PecsExample {
	public static void main(String[] args) {
		List<Dog> myDogs = new ArrayList<>(Arrays.asList(new Dog("dog1"), new Dog("dog2")));
		List<GenericDog> genDog = new ArrayList<>(Arrays.asList(new GenericDog("genDog1"), new GenericDog("genDog2")));

		// Illustrating Producer Extends
		displayDogs(genDog);
		displayDogs(myDogs);

		// Illustrating Consumer Super
		addAnimals(genDog, new GenericDog("genDog3"));
		addAnimals(genDog, new Dog("dog3"));
	}

	private static void displayDogs(List<? extends GenericDog> dogList) {
		for (Animal animal : dogList) {
			System.out.println(animal);
		}
		System.out.println();
	}

	private static void addAnimals(List<? super GenericDog> dogList, GenericDog dogs) {
		System.out.println("addAnimals");
		dogList.add(dogs);
		for (Object animal : dogList) {
			System.out.println(animal);
		}
		System.out.println();
	}
}
