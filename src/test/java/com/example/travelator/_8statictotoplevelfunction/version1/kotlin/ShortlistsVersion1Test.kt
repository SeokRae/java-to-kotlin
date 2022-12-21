package com.example.travelator._8statictotoplevelfunction.version1.kotlin

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class ShortlistsVersion1Test {

    @Test
    fun testCase1() {

        val actual = Shortlists.sorted(listOf(1, 2, 3, 4, 5), Comparator.comparing(Int::toInt))

        val expected = listOf(1, 2, 3, 4, 5)

        assertEquals(expected, actual)

    }
}