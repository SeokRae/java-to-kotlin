package com.example.travelator._14accumulatedobjecttoconverter.v6.itinerary

import com.example.travelator._14accumulatedobjecttoconverter.v6.money.CurrencyConversion
import com.example.travelator._14accumulatedobjecttoconverter.v6.money.Money


data class CostSummary(
    val lines: List<CurrencyConversion>,
    var total: Money,
)