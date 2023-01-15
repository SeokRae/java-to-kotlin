package com.example.travelator._14accumulatedobjecttoconverter.v1.iternerary

import com.example.travelator._14accumulatedobjecttoconverter.v1.money.ExchangeRates
import com.example.travelator._14accumulatedobjecttoconverter.v1.money.ExchangeRatesViaBaseCurrency
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class ItineraryTest {

    @DisplayName("14.1 테스트 코드")
    @Test
    fun testCase1() {
        val fx: ExchangeRates = ExchangeRatesViaBaseCurrency()
        val userCurrency = TODO()
        val calculator = CostSummaryCalculator(userCurrency, fx)

        fun costSummary(i: Itinerary): CostSummary {
            i.addCostsTo(calculator)
            return calculator.summarise()
        }
    }
}