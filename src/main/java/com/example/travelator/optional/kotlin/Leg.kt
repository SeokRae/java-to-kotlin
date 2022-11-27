package com.example.travelator.optional.kotlin

import kotlin.time.Duration

class Leg private constructor(val description: String, val plannedDuration: Duration) {


    companion object {
        @JvmStatic
        fun leg(name: String, duration: Duration): Leg {
            return Leg(name, duration)
        }
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is Leg) return false

        if (description != other.description) return false
        if (plannedDuration != other.plannedDuration) return false

        return true
    }

    override fun hashCode(): Int {
        var result = description.hashCode()
        result = 31 * result + plannedDuration.hashCode()
        return result
    }

    override fun toString(): String {
        return "Leg(description='$description', plannedDuration=$plannedDuration)"
    }


}