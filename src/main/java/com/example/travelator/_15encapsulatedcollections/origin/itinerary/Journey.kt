package com.example.travelator._15encapsulatedcollections.origin.itinerary

import com.example.travelator._15encapsulatedcollections.origin.Location
import java.time.Duration
import java.time.ZonedDateTime

data class Journey(
    val departsFrom: Location,
    val arrivesAt: Location,
    val departureTime: ZonedDateTime,
    val arrivalTime: ZonedDateTime,
    val method: TravelMethod
) {
    val duration: Duration
        get() = Duration.between(departureTime, arrivalTime)
}