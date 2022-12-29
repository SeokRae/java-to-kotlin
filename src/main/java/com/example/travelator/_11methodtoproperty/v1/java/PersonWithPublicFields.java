package com.example.travelator._11methodtoproperty.v1.java;

import java.time.LocalDate;

public class PersonWithPublicFields {
	
	public final String givenName;
	public final String familyName;
	public final LocalDate dateOfBirth;
	
	public PersonWithPublicFields(String givenName, String familyName, LocalDate dateOfBirth) {
		this.givenName = givenName;
		this.familyName = familyName;
		this.dateOfBirth = dateOfBirth;
	}
}
