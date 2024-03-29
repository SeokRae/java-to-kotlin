package com.example.travelator._11methodtoproperty.v8.kotlin

import java.time.LocalDate
import java.time.Period

data class PersonWithProperties(
    val givenName: String,
    val familyName: String,
    val dateOfBirth: LocalDate
) {
    val fullName: String get() = "$givenName $familyName"

    fun age() = Period.between(dateOfBirth, LocalDate.now()).years

    fun computeHash(): ByteArray = sumSlowHashOf(givenName, familyName, dateOfBirth.toString())


    private val hash: ByteArray by lazy { sumSlowHashOf(givenName, familyName, dateOfBirth.toString()) }

    fun hash() = hash

    private fun sumSlowHashOf(givenName: String, familyName: String, toString: String): ByteArray {
        TODO("Not yet implemented")
    }
}