package com.example.travelator.money.java;

import java.math.BigDecimal;
import java.util.Currency;
import java.util.Objects;

public class Money {
	private final BigDecimal amount;
	private final Currency currency;
	
	private Money(BigDecimal amount, Currency currency) {
		this.amount = amount;
		this.currency = currency;
	}
	
	public static Money of(BigDecimal amount, Currency currency) {
		return new Money(amount.setScale(currency.getDefaultFractionDigits()), currency);
	}
	
	public Money add(Money other) {
		if (!this.currency.equals(other.currency)) {
			throw new IllegalArgumentException("cannot add Money values in different currencies");
		}
		return new Money(amount.add(other.amount), currency);
	}
	
	public BigDecimal getAmount() {
		return amount;
	}
	
	public Currency getCurrency() {
		return currency;
	}
	
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Money money)) return false;
		return Objects.equals(amount, money.amount)
			&& Objects.equals(currency, money.currency);
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(amount, currency);
	}
	
	@Override
	public String toString() {
		return amount.toString() + " " + currency.getCurrencyCode();
	}
}
