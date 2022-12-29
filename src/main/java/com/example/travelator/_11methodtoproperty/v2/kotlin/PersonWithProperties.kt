package com.example.travelator._11methodtoproperty.v2.kotlin

import java.time.LocalDate

data class PersonWithProperties(
    val givenName: String,
    val familyName: String,
    val dateOfBirth: LocalDate,
)