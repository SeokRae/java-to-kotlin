package com.example.travelator.optional.advanced1

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import kotlin.time.Duration

internal class LegsKtTest {
    @Test
    internal fun testCase1() {
        longestLegOver(emptyList(), Duration.ZERO).let {
            Assertions.assertThat(it).isNull()
        }
    }
}