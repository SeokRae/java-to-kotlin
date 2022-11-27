package com.example.travelator.optional.kotlin

import com.example.travelator.optional.kotlin.Legs.longestLegOver
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import kotlin.time.Duration
import kotlin.time.Duration.Companion.days
import kotlin.time.Duration.Companion.hours
import kotlin.time.Duration.Companion.milliseconds
import kotlin.time.Duration.Companion.minutes

internal class LegsTest {


    private val legs: List<Leg> = listOf(
        Leg.leg("one hour", 1.hours),
        Leg.leg("one day", 1.days),
        Leg.leg("two hour", 2.hours),
    )

    private val oneDay: Duration = 1.days

    @Test
    internal fun `test case4`() { // two hour ??
        val actual = longestLegOver(legs, oneDay.minus(1.milliseconds))!!.description
        assertThat(actual).isEqualTo("one day")
    }

    @Test
    internal fun `test case5`() {
        val actual = longestLegOver(legs, 59.minutes)?.description
        assertThat(actual).isEqualTo("one day")
    }

    @Test
    fun `is absent when no legs`() {
        assertThat(longestLegOver(emptyList(), Duration.ZERO)).isNull()
    }

    @Test
    fun `is absent when no legs long enough`() {
        assertThat(longestLegOver(legs, oneDay)).isNull()
    }
}