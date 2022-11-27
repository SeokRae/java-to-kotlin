package com.example.travelator.travel.java;

public class Marketing {
	private Marketing() {
	}
	
	public static boolean isHotMailAddress(EmailAddress emailAddress) {
		return emailAddress.getDomain().equalsIgnoreCase("hotmail.com");
	}
}
