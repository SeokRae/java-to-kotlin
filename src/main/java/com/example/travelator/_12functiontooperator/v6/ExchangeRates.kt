package com.example.travelator._12functiontooperator.v6

import java.math.BigDecimal
import java.util.*

interface ExchangeRates {
    fun rate(fromCurrency: Currency, toCurrency: Currency): BigDecimal

    @Suppress("DEPRECATION")
    @JvmDefault
    fun convert(fromMoney: Money, toCurrency: Currency): CurrencyConversion {
        val rate = rate(fromMoney.currency, toCurrency)
        val toAmount = fromMoney.amount * rate
        val toMoney = Money(toAmount, toCurrency)
        return CurrencyConversion(fromMoney, toMoney)
    }
}