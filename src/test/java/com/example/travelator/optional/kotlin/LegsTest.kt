package com.example.travelator.optional.kotlin

import com.example.travelator.optional.kotlin.Legs.findLongestLegOver
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test
import java.util.*
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
    internal fun testCase1() {
        val actual = findLongestLegOver(emptyList(), Duration.ZERO)
        assertThat(actual).isEmpty
    }

    @Test
    internal fun testCase2() {
        val actual = findLongestLegOver(emptyList(), Duration.ZERO)
        assertThat(actual).isEqualTo(Optional.empty<Any>())
    }

    @Test
    internal fun testCase3() {
        val actual = findLongestLegOver(legs, oneDay)
        assertThat(actual).isEqualTo(Optional.empty<Any>())
    }

    @Test
    internal fun testCase4() { // two hour ??
        val actual = findLongestLegOver(legs, oneDay.minus(1.milliseconds))
            .orElseThrow().description
        assertThat(actual).isEqualTo("one day")
    }

    @Test
    internal fun testCase5() {
        val actual = findLongestLegOver(legs, 59.minutes)
            .orElseThrow().description
        assertThat(actual).isEqualTo("one day")
    }
}