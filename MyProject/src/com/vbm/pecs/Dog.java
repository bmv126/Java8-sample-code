package com.vbm.pecs;

public class Dog extends GenericDog {
	private String dogName;

	public Dog(String name) {
		super(name);
		dogName = name;
	}

	public String toString() {
		return "genericDog " + dogName;
	}
}
