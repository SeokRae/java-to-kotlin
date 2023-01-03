package com.example.travelator._12functiontooperator.v6

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import java.math.BigDecimal
import java.util.*

class MoneyTest {

    @DisplayName("코틀린 더하기 연산 처리 테스트")
    @Test
    fun testCase() {
        val money = Money.of(BigDecimal.valueOf(10.00), Currency.getInstance("USD"))

        val plus = money + Money.of(BigDecimal.valueOf(20.00), Currency.getInstance("USD"))

        assertThat(plus).isEqualTo(Money.of(BigDecimal.valueOf(30.00), Currency.getInstance("USD")))
    }
}