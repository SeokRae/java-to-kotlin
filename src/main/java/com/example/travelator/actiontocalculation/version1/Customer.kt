package com.example.travelator.actiontocalculation.version1

import java.util.*

data class Customer(
    val givenName: String,
    val familyName: String,
) {
    fun upperCaseGivenName() = givenName.uppercase(Locale.getDefault())
    val fullName get() = "$givenName $familyName"
}