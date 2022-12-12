package com.example.travelator.beansToValue.kotlin.study

import java.util.*

class UserPreferences(
    var greeting: String?,
    var locale: Locale?,
    var currency: Currency?,
) {
    constructor() : this("Hello", Locale.UK, Currency.getInstance(Locale.UK))
}