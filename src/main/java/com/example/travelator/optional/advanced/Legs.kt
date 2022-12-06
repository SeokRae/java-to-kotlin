package com.example.travelator.optional.advanced

import com.example.travelator.optional.kotlin.Leg
import kotlin.time.Duration

/**
 * 최상위 함수
 */
fun longestLegOver(
    legs: List<Leg>,
    duration: Duration,
): Leg? {
    var result: Leg? = null
    for (leg in legs) {
        if (leg.isLongerThan(duration) && (result == null || leg.isLongerThan(result.plannedDuration))) result = leg
    }
    return result
}

/**
 * Convert parameter to receiver(파라미터를 수신 객체로 변환)
 */
private fun Leg.isLongerThan(duration: Duration) =
    plannedDuration.compareTo(duration) > 0