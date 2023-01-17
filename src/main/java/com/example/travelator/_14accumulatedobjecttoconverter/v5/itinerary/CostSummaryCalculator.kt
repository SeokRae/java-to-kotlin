package com.example.travelator._14accumulatedobjecttoconverter.v5.itinerary

import com.example.travelator._14accumulatedobjecttoconverter.v5.money.ExchangeRates
import com.example.travelator._14accumulatedobjecttoconverter.v5.money.Money
import java.util.*

class CostSummaryCalculator(
    private val userCurrency: Currency,
    private val exchangeRates: ExchangeRates,
) {
    fun summarise(costs: Iterable<Money>): CostSummary {
        // 인스턴스 필드를 제거하는 데는 성공 했으나 아직 가변 map을 사용하고 있는 문제가 있다.
        val currencyTotals = mutableMapOf<Currency, Money>()
        costs.forEach {
            currencyTotals.merge(it.currency, it, Money::plus)
        }

        val lines = currencyTotals.values
            .sortedBy { it.currency.currencyCode }
            .map { exchangeRates.convert(it, userCurrency) }

        val total = lines
            .map { it.toMoney }
            .fold(Money.of(0, userCurrency), Money::add)

        return CostSummary(lines, total)
    }
}