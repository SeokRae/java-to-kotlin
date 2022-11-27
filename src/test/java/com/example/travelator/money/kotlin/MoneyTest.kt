package com.example.travelator.money.kotlin

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import java.math.BigDecimal
import java.util.*

internal class MoneyTest {
    @DisplayName("should add money values of the same currency")
    @Test
    internal fun testCase1() {
        val currency = Currency.getInstance("USD")
        val money = Money.of(BigDecimal("10.00"), currency)
        val other = Money.of(BigDecimal("20.00"), currency)

        val actual = money.add(other)

        assertThat(Money.of(BigDecimal("30.00"), currency))
            .isEqualTo(actual)
    }
}