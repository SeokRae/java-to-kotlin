package com.example.travelator._12functiontooperator.v6

import java.math.BigDecimal
import java.util.*

class Money private constructor(
    val amount: BigDecimal,
    val currency: Currency,
) {
    override fun equals(other: Any?) =
        this === other ||
                other is Money &&
                amount == other.amount &&
                currency == other.currency

    override fun hashCode() =
        Objects.hash(amount, currency)

    override fun toString() =
        amount.toString() + " " + currency.currencyCode

    /**
     * replace with +
     */
    fun add(that: Money): Money = this + that

    operator fun plus(that: Money): Money {
        require(currency == that.currency) {
            "cannot add Money values of different currencies"
        }
        return Money(this.amount + that.amount, currency)
    }

    companion object {
        @JvmStatic
        fun of(amount: BigDecimal, currency: Currency) =
            this(amount, currency)

        /**
         * 연산자 operator로 변경
         */
        operator fun invoke(
            amount: BigDecimal,
            currency: Currency,
        ) = Money (
            amount.setScale(currency.defaultFractionDigits),
            currency
        )
    }
}