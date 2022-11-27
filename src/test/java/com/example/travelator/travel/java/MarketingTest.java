package com.example.travelator.travel.java;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class MarketingTest {
	
	@DisplayName("should return true when domain is hotmail.com")
	@Test
	void testCase1() {
		EmailAddress mail = new EmailAddress("seok", "hotmail.com");
		
		boolean actual = Marketing.isHotMailAddress(mail);
		
		assertThat(actual).isTrue();
	}
}