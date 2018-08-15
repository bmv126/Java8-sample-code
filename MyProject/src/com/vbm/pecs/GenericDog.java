package com.vbm.pecs;

public class GenericDog extends Animal {

	private String genericDogName;

	public GenericDog(String name) {
		genericDogName = name;
	}

	public String toString() {
		return "genericDog " + genericDogName;
	}
}
