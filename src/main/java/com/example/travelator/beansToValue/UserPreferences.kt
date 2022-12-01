package com.example.travelator.beansToValue

import java.util.*

data class UserPreferences(
    val greeting: String,
    val locale: Locale,
    val currency: Currency
)