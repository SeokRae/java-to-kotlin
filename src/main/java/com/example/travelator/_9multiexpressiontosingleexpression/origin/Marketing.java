package com.example.travelator._9multiexpressiontosingleexpression.origin;

public class Marketing {
	
	public static boolean isHotmailAddress(EmailAddress address) {
		return address.getDomain().equalsIgnoreCase("hotmail.com");
	}
}