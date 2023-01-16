package com.example.travelator._14accumulatedobjecttoconverter.v3.itinerary

import com.example.travelator._14accumulatedobjecttoconverter.v3.money.CurrencyConversion
import com.example.travelator._14accumulatedobjecttoconverter.v3.money.Money
import java.util.*

class CostSummary(
    userCurrency: Currency,
    val lines: List<CurrencyConversion>,

) {

    private val _lines = mutableListOf<CurrencyConversion>()

    var total: Money = Money.of(0, userCurrency)
        private set

    // 끔찍한 코드 아닌가?
    init {
        lines.forEach {
            total += it.toMoney
        }
    }

    fun addLine(line: CurrencyConversion) {
        _lines.add(line)
        // add에서 plus로 변경하면 += 연산자를 사용할 수 있음
        total += line.toMoney
    }
}