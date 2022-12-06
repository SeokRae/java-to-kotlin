package com.example.travelator.beansToValue.kotlin.version1

import com.example.travelator.beansToValue.CurrencyPicker
import com.example.travelator.beansToValue.GreetingPicker
import com.example.travelator.beansToValue.LocalePicker

/**
 * 가변 데이터에서 전형적으로 드러날 수 있는 복잡성 투성인 객체
 */
class PreferencesView(
    private var preferences: UserPreferences,
) : View() {
    private val greetingPicker = GreetingPicker()
    private val localePicker = LocalePicker()
    private val currencyPicker = CurrencyPicker()

    override fun show() {
        greetingPicker.greeting = preferences.greeting
        localePicker.locale = preferences.locale
        currencyPicker.currency = preferences.currency
        super.show()
    }

    protected fun onGreetingChange() {
        preferences = UserPreferences(
            greetingPicker.greeting,
            preferences.locale,
            preferences.currency
        )
    }

    protected fun onLocaleChange() {
        preferences = UserPreferences(
            preferences.greeting,
            localePicker.locale,
            preferences.currency
        )
    }

    protected fun onCurrencyChange() {
        preferences = UserPreferences(
            preferences.greeting,
            preferences.locale,
            currencyPicker.currency
        )
    }
}