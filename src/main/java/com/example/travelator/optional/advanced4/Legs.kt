package com.example.travelator.optional.advanced4

import com.example.travelator.optional.kotlin.Leg
import kotlin.time.Duration

/**
 * 최상위 함수
 */
fun longestLegOver(
    legs: List<Leg>,
    duration: Duration
): Leg? {
    val longest = legs.maxByOrNull(Leg::plannedDuration) ?: return null
    return if (longest.plannedDuration > duration) {
        longest
    } else {
        null
    }
}