package com.example.travelator.optional.kotlin

import java.util.*
import kotlin.time.Duration

object Legs {

    @JvmStatic
    fun findLongestLegOver(
        legs: List<Leg>,
        duration: Duration
    ): Optional<Leg> {
        var result: Leg? = null
        for (leg in legs) {
            if (isLongerThan(leg, duration)
                && (result == null ||
                        isLongerThan(leg, result.plannedDuration))
            ) {
                result = leg
            }
        }
        return Optional.ofNullable(result)
    }

    private fun isLongerThan(leg: Leg, duration: Duration): Boolean {
        return leg.plannedDuration.compareTo(duration) > 0
    }
}