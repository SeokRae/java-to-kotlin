package com.example.travelator._11methodtoproperty.v1.java;

import java.time.LocalDate;

public class PersonWithPublicFields {
	
	private final String givenName;
	private final String familyName;
	private final LocalDate dateOfBirth;
	
	public PersonWithPublicFields(String givenName, String familyName, LocalDate dateOfBirth) {
		this.givenName = givenName;
		this.familyName = familyName;
		this.dateOfBirth = dateOfBirth;
	}
	
	public String getGivenName() {
		return givenName;
	}
	
	public String getFamilyName() {
		return familyName;
	}
	
	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}
}
