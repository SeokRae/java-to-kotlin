package com.example.travelator.beansToValue.java;

import com.example.travelator.beansToValue.CurrencyPicker;
import com.example.travelator.beansToValue.GreetingPicker;
import com.example.travelator.beansToValue.LocalePicker;
import com.example.travelator.beansToValue.View;

/**
 * 가변 데이터에서 전형적으로 드러날 수 있는 복잡성 투성인 객체
 */
public class PreferencesView extends View {
	
	private final UserPreferences preferences;
	private final GreetingPicker greetingPicker = new GreetingPicker();
	private final LocalePicker localePicker = new LocalePicker();
	private final CurrencyPicker currencyPicker = new CurrencyPicker();
	
	public PreferencesView(UserPreferences preferences) {
		this.preferences = preferences;
	}
	
	public void show() {
		greetingPicker.setGreeting(preferences.getGreeting());
		localePicker.setLocale(preferences.getLocale());
		currencyPicker.setCurrency(preferences.getCurrency());
		super.show();
	}
	
	protected void onGreetingChange() {
		preferences.setGreeting(greetingPicker.getGreeting());
	}
	
	protected void onLocaleChange() {
		preferences.setLocale(localePicker.getLocale());
	}
	
	protected void onCurrencyChange() {
		preferences.setCurrency(currencyPicker.getCurrency());
	}
}