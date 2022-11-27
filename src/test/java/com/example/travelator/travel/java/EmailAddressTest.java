package com.example.travelator.travel.java;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class EmailAddressTest {
	
	@DisplayName("should parse email address")
	@Test
	void testCase1() {
		EmailAddress actual = new EmailAddress("seok", "example.com");
		EmailAddress expected = EmailAddress.parse("seok@example.com");
		assertThat(actual).isEqualTo(expected);
	}
	
	@DisplayName("should throw exception when email address is invalid")
	@Test
	void testCase2() {
		assertThatExceptionOfType(IllegalArgumentException.class)
			.isThrownBy(() -> EmailAddress.parse("@"))
			.withMessage("EmailAddress must be two parts separated by @");
	}
}