package com.example.travelator._12functiontooperator.v1

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import java.math.BigDecimal
import java.util.*

class MoneyTest {

    @Test
    fun testCase1() {
        // given
        val of = Money.of(BigDecimal("10.00"), Currency.getInstance("USD"))

        // when
        val add = of + Money.of(BigDecimal("20.00"), Currency.getInstance("USD"))

        // then
        assertThat(add).isEqualTo(Money.of(BigDecimal("30.00"), Currency.getInstance("USD")))
    }
}