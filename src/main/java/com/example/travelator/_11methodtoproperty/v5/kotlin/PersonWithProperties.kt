package com.example.travelator._11methodtoproperty.v5.kotlin

import java.time.LocalDate

data class PersonWithProperties(
    val givenName: String,
    val familyName: String,
    val dateOfBirth: LocalDate,
) {
    val fullName: String get() = "$givenName $familyName"
}