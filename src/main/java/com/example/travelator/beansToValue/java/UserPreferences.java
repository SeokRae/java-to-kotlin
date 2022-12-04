package com.example.travelator.beansToValue.java;

import java.util.Currency;
import java.util.Locale;

/**
 * 동등성과 해시 코드가 가변 프로퍼티 값에 따라 결정
 * -> UserPreferences를 집합에 넣어거나 맵의 키로 사용할 수 없다.
 */
public class UserPreferences {
	private String greeting;
	private Locale locale;
	private Currency currency;
	
	public UserPreferences() {
		this("Hello", Locale.UK, Currency.getInstance(Locale.UK));
	}
	
	public UserPreferences(String greeting, Locale locale, Currency currency) {
		this.greeting = greeting;
		this.locale = locale;
		this.currency = currency;
	}
	
	public String getGreeting() {
		return greeting;
	}
	
	public void setGreeting(String greeting) {
		this.greeting = greeting;
	}
	
	public Locale getLocale() {
		return locale;
	}
	
	public void setLocale(Locale locale) {
		this.locale = locale;
	}
	
	public Currency getCurrency() {
		return currency;
	}
	
	public void setCurrency(Currency currency) {
		this.currency = currency;
	}
}
