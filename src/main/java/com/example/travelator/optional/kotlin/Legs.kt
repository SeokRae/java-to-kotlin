package com.example.travelator.optional.kotlin

import kotlin.time.Duration

object Legs {
    @JvmStatic
    fun longestLegOver(
        legs: List<Leg>,
        duration: Duration,
    ): Leg? {
        var result: Leg? = null
        for (leg in legs) {
            if (isLongerThan(leg, duration)) {
                if (result == null ||
                    isLongerThan(leg, result.plannedDuration)
                ) {
                    result = leg
                }
            }
        }
        return result
    }

    private fun isLongerThan(leg: Leg, duration: Duration): Boolean {
        return leg.plannedDuration.compareTo(duration) > 0
    }
}