package com.example.travelator.optional.advanced5

import com.example.travelator.optional.kotlin.Leg
import kotlin.time.Duration

/**
 * 최상위 함수
 */
fun longestLegOver(
    legs: List<Leg>,
    duration: Duration
): Leg? =
    legs.maxByOrNull(Leg::plannedDuration)?.let { longestLeg ->
        if (longestLeg.plannedDuration > duration)
            return longestLeg
        else
            return null
    }