package com.example.travelator.optional.advanced8

import com.example.travelator.optional.kotlin.Leg
import kotlin.time.Duration

/**
 * 최상위 함수
 */
fun longestLegOver(
    legs: List<Leg>,
    duration: Duration,
): Leg? =
    legs.maxByOrNull(Leg::plannedDuration)
        /**
         * ?.takeIf는 술어가 true 면 수신 객체를 반환하고 true가 아니면 null 반환한다.
         */
        ?.takeIf { longestLeg ->
            longestLeg.plannedDuration > duration
        }