package com.example.travelator._14accumulatedobjecttoconverter.v2.itinerary

import com.example.travelator._14accumulatedobjecttoconverter.v2.money.CurrencyConversion
import com.example.travelator._14accumulatedobjecttoconverter.v2.money.Money
import java.util.*

class CostSummary(userCurrency: Currency) {

    private val _lines = mutableListOf<CurrencyConversion>()

    var total: Money = Money.of(0, userCurrency)
        private set

    val lines: List<CurrencyConversion>
        get() = _lines.toList()
    fun addLine(line: CurrencyConversion) {
        _lines.add(line)
        // add에서 plus로 변경하면 += 연산자를 사용할 수 있음
        total += line.toMoney
    }
}