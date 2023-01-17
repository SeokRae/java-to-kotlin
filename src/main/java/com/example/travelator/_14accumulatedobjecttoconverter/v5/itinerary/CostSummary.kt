package com.example.travelator._14accumulatedobjecttoconverter.v5.itinerary

import com.example.travelator._14accumulatedobjecttoconverter.v5.money.CurrencyConversion
import com.example.travelator._14accumulatedobjecttoconverter.v5.money.Money


data class CostSummary(
    val lines: List<CurrencyConversion>,
    var total: Money,
)