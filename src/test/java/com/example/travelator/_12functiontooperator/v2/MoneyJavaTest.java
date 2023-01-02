package com.example.travelator._12functiontooperator.v2;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Currency;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class MoneyJavaTest {
	@Test
	void testCase1() {
		Money usd = Money.of(BigDecimal.valueOf(10), Currency.getInstance("USD"));
		
		Money actual = usd.add(Money.of(BigDecimal.valueOf(10), Currency.getInstance("USD")));
		
		assertThat(actual).isEqualTo(Money.of(BigDecimal.valueOf(20), Currency.getInstance("USD")));
	}
}
