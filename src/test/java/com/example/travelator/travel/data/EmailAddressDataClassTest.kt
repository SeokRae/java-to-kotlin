package com.example.travelator.travel.data

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

internal class EmailAddressDataClassTest {

    @DisplayName("Copy 메서드 테스트")
    @Test
    internal fun testCase1() {
        val emailAddress = EmailAddress("seok", "example.com");
        val actual = emailAddress.copy(localPart = "rae")
        assertThat(actual.toString()).isEqualTo("rae@example.com");
    }

    @DisplayName("Copy 와는 별개로 원본 객체 테스트")
    @Test
    internal fun testCase2() {
        val emailAddress = EmailAddress("seok", "example.com");
        emailAddress.copy(localPart = "rae")
        assertThat(emailAddress.toString()).isEqualTo("seok@example.com");
    }
}