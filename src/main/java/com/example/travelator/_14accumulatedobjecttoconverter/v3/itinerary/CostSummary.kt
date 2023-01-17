package com.example.travelator._14accumulatedobjecttoconverter.v3.itinerary

import com.example.travelator._14accumulatedobjecttoconverter.v3.money.CurrencyConversion
import com.example.travelator._14accumulatedobjecttoconverter.v3.money.Money

class CostSummary(
    val lines: List<CurrencyConversion>,
    var total: Money,
)