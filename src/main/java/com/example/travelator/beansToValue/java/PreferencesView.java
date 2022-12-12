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
	
	/**
	 * 속성 값을 초기화
	 * <p>
	 * 하지만 Wrapper 클래스만 알고 있는 것이 좋다.
	 */
	public PreferencesView(UserPreferences preferences) {
		this.preferences = preferences;
	}
	
	public void show() {
		greetingPicker.setGreeting(preferences.getGreeting());
		localePicker.setLocale(preferences.getLocale());
		currencyPicker.setCurrency(preferences.getCurrency());
		super.show();
	}
	
	/**
	 * 속성 값 변경 메서드들
	 */
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