package com.example.travelator._14accumulatedobjecttoconverter.v4.itinerary

import com.example.travelator._14accumulatedobjecttoconverter.v4.money.CurrencyConversion
import com.example.travelator._14accumulatedobjecttoconverter.v4.money.Money


data class CostSummary(
    val lines: List<CurrencyConversion>,
    var total: Money,
)