package com.example.travelator.optional.advanced9

import com.example.travelator.optional.kotlin.Leg
import kotlin.time.Duration

/**
 * 최상위 함수
 */
fun List<Leg>.longestLegOver(duration: Duration): Leg? {
    val longest = maxByOrNull(Leg::plannedDuration)
    return when {
        longest == null -> null
        longest.plannedDuration > duration -> longest
        else -> null
    }
}