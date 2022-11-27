package com.example.travelator.optional.advanced4

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import kotlin.time.Duration

internal class LegsKtTest {
    @Test
    internal fun testCase1() {
        longestLegOver(emptyList(), Duration.ZERO).let {
            assertThat(it).isNull()
        }
    }
}