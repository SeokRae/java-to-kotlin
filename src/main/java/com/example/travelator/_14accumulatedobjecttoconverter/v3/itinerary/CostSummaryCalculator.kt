package com.example.travelator._14accumulatedobjecttoconverter.v3.itinerary

import com.example.travelator._14accumulatedobjecttoconverter.v3.money.ExchangeRates
import com.example.travelator._14accumulatedobjecttoconverter.v3.money.Money
import java.util.*

class CostSummaryCalculator(
    private val userCurrency: Currency,
    private val exchangeRates: ExchangeRates,
) {
    private val currencyTotals = mutableMapOf<Currency, Money>()

    fun addCost(cost: Money) {
        currencyTotals.merge(cost.currency, cost, Money::add)
    }

    fun summarise(): CostSummary {
        val conversions = currencyTotals.values.sortedBy {
            it.currency.currencyCode
        }.map {
            exchangeRates.convert(it, userCurrency)
        }
        return CostSummary(userCurrency, conversions)
    }

    fun reset() {
        currencyTotals.clear()
    }
}