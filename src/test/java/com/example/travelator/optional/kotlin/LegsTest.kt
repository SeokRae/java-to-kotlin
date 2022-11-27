package com.example.travelator.optional.kotlin

import com.example.travelator.optional.kotlin.Legs.findLongestLegOver
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import kotlin.time.Duration

internal class LegsTest {

    @Test
    internal fun testCase1() {
        val actual = findLongestLegOver(emptyList(), Duration.ZERO)
        assertThat(actual).isEmpty
    }

}