package com.example.travelator._11methodtoproperty.v6.kotlin

import java.time.LocalDate
import java.time.Period

data class PersonWithProperties(
    val givenName: String,
    val familyName: String,
    val dateOfBirth: LocalDate,
) {
    val fullName: String get() = "$givenName $familyName"

    fun age() = Period.between(dateOfBirth, LocalDate.now()).years
}