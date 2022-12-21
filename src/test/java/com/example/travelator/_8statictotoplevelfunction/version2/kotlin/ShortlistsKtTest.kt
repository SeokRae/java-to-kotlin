package com.example.travelator._8statictotoplevelfunction.version2.kotlin

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class ShortlistsKtTest {
    @Test
    fun testCase1() {

        val actual = sorted(listOf(1, 2, 3, 4, 5), Comparator.comparing(Int::toInt))

        val expected = listOf(1, 2, 3, 4, 5)

        assertThat(actual).isEqualTo(expected)

    }
}