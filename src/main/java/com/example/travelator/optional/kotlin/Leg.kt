package com.example.travelator.optional.kotlin

import kotlin.time.Duration

class Leg private constructor(val description: String, val plannedDuration: Duration) {

    companion object {
        @JvmStatic
        fun leg(name: String, duration: Duration): Leg {
            return Leg(name, duration)
        }
    }
}