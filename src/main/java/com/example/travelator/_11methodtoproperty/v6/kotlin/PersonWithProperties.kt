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

    fun computeHash(): ByteArray = sumSlowHashOf(givenName, familyName, dateOfBirth.toString())

    /**
     * hash 접근 여부와 관계 없이 모든 인스턴스 생성이 느림
     */
    val hash: ByteArray = sumSlowHashOf(givenName, familyName, dateOfBirth.toString())

    private fun sumSlowHashOf(givenName: String, familyName: String, toString: String): ByteArray {
        TODO("Not yet implemented")
    }
}