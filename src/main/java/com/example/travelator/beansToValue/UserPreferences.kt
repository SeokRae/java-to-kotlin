package com.example.travelator.beansToValue

import java.util.*

/**
 * final class
 * private final properties
 *
 * AllArguments Constructor
 *
 * copy()
 * toString()
 * equals & hashCode
 *
 */
data class UserPreferences(
    val greeting: String,
    val locale: Locale,
    val currency: Currency,
)