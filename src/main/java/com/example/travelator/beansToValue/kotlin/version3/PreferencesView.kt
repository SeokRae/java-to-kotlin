package com.example.travelator.beansToValue.kotlin.version3

import com.example.travelator.beansToValue.CurrencyPicker
import com.example.travelator.beansToValue.GreetingPicker
import com.example.travelator.beansToValue.LocalePicker


/**
 * 가변 데이터에서 전형적으로 드러날 수 있는 복잡성 투성인 객체
 */
class PreferencesView : View() {
    private val greetingPicker = GreetingPicker()
    private val localePicker = LocalePicker()
    private val currencyPicker = CurrencyPicker()

    fun showModel(preferences: UserPreferences): UserPreferences {
        greetingPicker.greeting = preferences.greeting
        localePicker.locale = preferences.locale
        currencyPicker.currency = preferences.currency
        show()
        return UserPreferences(
            greeting = greetingPicker.greeting,
            locale = localePicker.locale,
            currency = currencyPicker.currency
        )
    }
}