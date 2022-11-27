package com.example.travelator.travel.kotlin

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

internal class MarketingTest {

    @DisplayName("should recognize hotmail addresses")
    @Test
    internal fun testCase1() {
        val emailAddress = EmailAddress.parse("seok@hotmail.com")
        val actual = Marketing.isHotMailAddress(emailAddress)
        assertThat(actual).isTrue
    }

}