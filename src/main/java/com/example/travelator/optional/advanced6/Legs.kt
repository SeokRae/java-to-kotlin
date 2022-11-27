package com.example.travelator.optional.advanced6

import com.example.travelator.optional.kotlin.Leg
import kotlin.time.Duration

/**
 * 최상위 함수
 */
fun longestLegOver(
    legs: List<Leg>,
    duration: Duration
): Leg? =
    /**
     * ?.는 수신 객체가 null이면 null로 평가, 그렇지 않으면 let 블록으로 가장 긴 구간을 전달
     */
    legs.maxByOrNull(Leg::plannedDuration)?.let { longestLeg ->
        if (longestLeg.plannedDuration > duration)
            return longestLeg
        else
            return null
    }