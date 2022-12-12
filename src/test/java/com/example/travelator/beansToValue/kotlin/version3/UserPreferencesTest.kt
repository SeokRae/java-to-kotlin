package com.example.travelator.beansToValue.kotlin.version3

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import java.util.*

class UserPreferencesTest {

    @DisplayName("UserPreferences는 불변이다")
    @Test
    fun testCase1() {

        val actual = UserPreferences("Hello", Locale.UK, Currency.getInstance(Locale.UK))
        val expected = UserPreferences("Hello", Locale.UK, Currency.getInstance(Locale.UK))

        assertThat(actual).isEqualTo(expected)
    }

}