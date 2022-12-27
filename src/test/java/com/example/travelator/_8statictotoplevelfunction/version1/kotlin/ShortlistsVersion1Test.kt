package com.example.travelator._8statictotoplevelfunction.version1.kotlin

import com.example.travelator._8statictotoplevelfunction.version1.kotlin.Shortlists.sorted
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class ShortlistsVersion1Test {

    @Test
    fun testCase1() {

        val actual = sorted(listOf(1, 2, 3, 4, 5), Comparator.comparing(Int::toInt))

        val expected = listOf(1, 2, 3, 4, 5)

        assertEquals(expected, actual)
    }
}