package com.example.travelator._14accumulatedobjecttoconverter.v2.itinerary

import com.example.travelator._14accumulatedobjecttoconverter.v2.money.ExchangeRates
import com.example.travelator._14accumulatedobjecttoconverter.v2.money.Money
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
        val totals = currencyTotals.values.sortedBy { it.currency.currencyCode }
        val summary = CostSummary(userCurrency)
        for (total in totals) {
            summary.addLine(exchangeRates.convert(total, userCurrency))
        }
        return summary
    }

    fun reset() {
        currencyTotals.clear()
    }
}