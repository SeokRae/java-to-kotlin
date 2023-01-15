package com.example.travelator._14accumulatedobjecttoconverter.v1.itinerary

import com.example.travelator._14accumulatedobjecttoconverter.v1.money.ExchangeRates
import com.example.travelator._14accumulatedobjecttoconverter.v1.money.ExchangeRatesViaBaseCurrency
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import java.util.*

class ItineraryTest {


    @DisplayName("14.1 테스트 코드 ")
    @Test
    fun testCase1() {
        // 고객이 선호하는 Currency(통화)와 환율 데이터 소스를 주입
        val fx: ExchangeRates = ExchangeRatesViaBaseCurrency(Currency.getInstance("USD"))
        val userCurrency = TODO()
        val calculator = CostSummaryCalculator(userCurrency, fx)

        fun costSummary(i: Itinerary): CostSummary {
            i.addCostsTo(calculator)
            return calculator.summarise()
        }
    }

}