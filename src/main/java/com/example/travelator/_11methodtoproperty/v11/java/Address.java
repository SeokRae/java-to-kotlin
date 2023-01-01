package com.example.travelator._11methodtoproperty.v11.java;

public class Address {
	private final String countryCode;
	private final String region;
	
	public Address(String countryCode, String region) {
		this.countryCode = countryCode;
		this.region = region;
	}
	
	public String getCountryCode() {
		return countryCode;
	}
	
	public String getRegion() {
		return region;
	}
}
