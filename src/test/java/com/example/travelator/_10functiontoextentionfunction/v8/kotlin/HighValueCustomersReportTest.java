package com.example.travelator._10functiontoextentionfunction.v8.kotlin;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class HighValueCustomersReportTest {
	@Test
	void testCase1() {
		CustomerData actual = HighValueCustomersReportKt.toCustomerData("1\tFred\tFlintstone\t0");
		CustomerData expected = new CustomerData("1", "Fred", "Flintstone", 0, 0D);
		assertThat(actual).isEqualTo(expected);
	}
}
