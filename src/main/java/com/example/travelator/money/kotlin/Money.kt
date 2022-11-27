package com.example.travelator.money.kotlin

import java.math.BigDecimal
import java.util.*

class Money
/**
 * 주 생성자를 사용하지만 생성자 앞에 private를 추가
 */
private constructor(
    val amount: BigDecimal,
    val currency: Currency
) {
    override fun equals(other: Any?): Boolean {
        if(this === other) return true
        if(other == null || javaClass != other.javaClass) return false
        val money = other as Money
        return amount == money.amount && currency == money.currency
    }

    override fun hashCode(): Int {
        return Objects.hash(amount, currency)
    }

    override fun toString(): String {
        return amount.toString() + " " + currency.currencyCode
    }

    fun add(other: Money): Money {
        require(currency == other.currency) { "cannot add Money values of different currencies" }
        return Money(amount.add(other.amount), currency)
    }

    companion object {
        @JvmStatic
        fun of(amount: BigDecimal, currency: Currency): Money {
            return Money(amount.setScale(currency.defaultFractionDigits), currency)
        }
    }

}