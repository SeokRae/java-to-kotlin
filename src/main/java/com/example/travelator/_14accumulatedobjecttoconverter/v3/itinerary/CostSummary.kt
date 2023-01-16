package com.example.travelator._14accumulatedobjecttoconverter.v3.itinerary

import com.example.travelator._14accumulatedobjecttoconverter.v3.money.CurrencyConversion
import com.example.travelator._14accumulatedobjecttoconverter.v3.money.Money
import java.util.*

class CostSummary(
    userCurrency: Currency,
    val lines: List<CurrencyConversion>,

) {
    var total = lines
        .map { it.toMoney }
        .fold(Money(0, userCurrency), Money::add)
}