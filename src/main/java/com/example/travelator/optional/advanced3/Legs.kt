package com.example.travelator.optional.advanced3

import com.example.travelator.optional.kotlin.Leg
import kotlin.time.Duration

/**
 * 최상위 함수
 */
fun longestLegOver(
    legs: List<Leg>,
    duration: Duration,
): Leg? {
    val longest = legs.maxByOrNull(Leg::plannedDuration)
    return if (longest != null && longest.plannedDuration > duration) {
        longest
    } else {
        null
    }
}