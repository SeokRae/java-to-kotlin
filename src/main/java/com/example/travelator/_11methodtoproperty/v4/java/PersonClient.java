package com.example.travelator._11methodtoproperty.v4.java;

public class PersonClient {
	
	public static String findAndAccessor(PersonWithPublicFields person) {
		return person.givenName + " " + person.getFullName();
	}
}
