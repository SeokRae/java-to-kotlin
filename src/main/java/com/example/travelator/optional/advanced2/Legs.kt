package com.example.travelator.optional.advanced2

import com.example.travelator.optional.kotlin.Leg
import kotlin.time.Duration

/**
 * 최상위 함수
 */
fun longestLegOver(
    legs: List<Leg>,
    duration: Duration
): Leg? {
    val longest = legs.maxByOrNull(Leg::plannedDuration)
    if (longest != null && longest.plannedDuration > duration) {
        return longest
    } else {
        return null
    }
}