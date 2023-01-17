package com.example.travelator._14accumulatedobjecttoconverter.v4.itinerary

import com.example.travelator._14accumulatedobjecttoconverter.v4.money.ExchangeRates
import com.example.travelator._14accumulatedobjecttoconverter.v4.money.Money
import java.util.*

class CostSummaryCalculator(
    private val userCurrency: Currency,
    private val exchangeRates: ExchangeRates,
) {
    private val currencyTotals = mutableMapOf<Currency, Money>()

    fun addCost(cost: Money) {
        currencyTotals.merge(cost.currency, cost, Money::add)
    }

    /**
     * summarise 메서드를 오버로딩 해서 비용을 취하는 메서드를 추가하는 방식을 채택 (계산)
     */
    fun summarise(costs: Iterable<Money>): CostSummary {
        val delegate = CostSummaryCalculator(userCurrency, exchangeRates)
        costs.forEach(delegate::addCost)
        return delegate.summarise()
    }

    fun summarise(): CostSummary {
        val lines = currencyTotals.values
            .sortedBy { it.currency.currencyCode }
            .map { exchangeRates.convert(it, userCurrency) }

        val total = lines
            .map { it.toMoney }
            .fold(Money.of(0, userCurrency), Money::add)

        return CostSummary(lines, total)
    }

    fun reset() {
        currencyTotals.clear()
    }
}