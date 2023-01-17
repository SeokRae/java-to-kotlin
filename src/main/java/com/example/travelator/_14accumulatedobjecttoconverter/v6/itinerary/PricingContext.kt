package com.example.travelator._14accumulatedobjecttoconverter.v6.itinerary

import com.example.travelator._14accumulatedobjecttoconverter.v6.money.CurrencyConversion
import com.example.travelator._14accumulatedobjecttoconverter.v6.money.ExchangeRates
import com.example.travelator._14accumulatedobjecttoconverter.v6.money.Money
import java.util.*

class PricingContext(
    private val userCurrency: Currency,
    private val exchangeRates: ExchangeRates,
) {
    fun toUserCurrency(money: Money) = exchangeRates
        .convert(money, userCurrency)

    fun summarise(costs: Iterable<Money>): CostSummary {
        // 통화별로 그룹을 나누고 ㅏㄱ 그룹에 속한 리스트의 합계를 구함
        val currencyTotals: List<Money> = costs
            .groupBy { it.currency }
            .values
            .map { it.sumOrNull() ?: error("should be a single element") }

        // 통화별 정렬 후 사용자 통화로 변환
        val lines: List<CurrencyConversion> = currencyTotals
            .sortedBy { it.currency.currencyCode }
            .map(::toUserCurrency)

        val total: Money = lines
            .map { it.toMoney }
            .sum { userCurrency }

        return CostSummary(lines, total)
    }
}

private fun <E> List<E>.sumOrNull(): Nothing? {
    TODO("Not yet implemented")
}

private fun <E> List<E>.sum(function: () -> Currency): E {
    TODO("Not yet implemented")
}
