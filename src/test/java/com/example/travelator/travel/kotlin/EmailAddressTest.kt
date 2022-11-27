package com.example.travelator.travel.kotlin

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatExceptionOfType
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

internal class EmailAddressTest {

    @DisplayName("should parse email address")
    @Test
    internal fun readDomain() {
        val emailAddress = EmailAddress("seok", "example.com")
        val actual = emailAddress.domain
        assertThat(actual).isEqualTo("example.com")
    }

    @DisplayName("should parse valid email address")
    @Test
    internal fun parsing() {
        val actual = EmailAddress("seok", "example.com")
        val expected = EmailAddress.parse("seok@example.com")
        assertThat(actual).isEqualTo(expected)
    }

    @DisplayName("should throw exception for invalid email address")
    @Test
    internal fun parsingFailures() {
        assertThatExceptionOfType(IllegalArgumentException::class.java)
            .isThrownBy { EmailAddress.parse("@") }
            .withMessage("Invalid email address: @")
    }
}