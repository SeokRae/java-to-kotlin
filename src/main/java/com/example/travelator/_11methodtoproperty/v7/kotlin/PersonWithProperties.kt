package com.example.travelator._11methodtoproperty.v7.kotlin

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
     * 지연 프로퍼티를 사용하면 hash를 사용하는 인스턴스와 그렇지 않은 인스턴스의 계산 비용을 다르게 함
     */
    val hash: ByteArray by lazy { sumSlowHashOf(givenName, familyName, dateOfBirth.toString()) }

    private fun sumSlowHashOf(givenName: String, familyName: String, toString: String): ByteArray {
        TODO("Not yet implemented")
    }
}