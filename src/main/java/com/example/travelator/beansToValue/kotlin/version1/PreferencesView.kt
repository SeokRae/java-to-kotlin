package com.example.travelator.beansToValue.kotlin.version1

import com.example.travelator.beansToValue.CurrencyPicker
import com.example.travelator.beansToValue.GreetingPicker
import com.example.travelator.beansToValue.LocalePicker

/**
 * 가변 데이터에서 전형적으로 드러날 수 있는 복잡성 투성인 객체
 */
class PreferencesView(
    private var preferences: UserPreferences
) : View() {
    private val greetingPicker = GreetingPicker()
    private val localePicker = LocalePicker()
    private val currencyPicker = CurrencyPicker()
    /**
     * 기존의 가변 preferences 프로퍼티를 반환
     */
    fun showModal(): UserPreferences {
        greetingPicker.greeting = preferences.greeting
        localePicker.locale = preferences.locale
        currencyPicker.currency = preferences.currency
        show()
        return preferences
    }

    protected fun onGreetingChange() {
        preferences = UserPreferences(
            greetingPicker.greeting,
            localePicker.locale,
            currencyPicker.currency
        )
    }

    protected fun onLocaleChange() {
        preferences.locale = localePicker.locale
    }

    protected fun onCurrencyChange() {
        preferences.currency = currencyPicker.currency
    }
}