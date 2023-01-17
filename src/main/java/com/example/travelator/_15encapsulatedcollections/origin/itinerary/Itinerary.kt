package com.example.travelator._15encapsulatedcollections.origin.itinerary

import com.example.travelator._15encapsulatedcollections.origin.Id
import travelator.itinerary.Route
import java.time.Duration

data class Itinerary(
    val id: Id<Itinerary>,
    val route: Route
) : Route by route {

    fun withTransformedRoute(transform: (Route).() -> Route) =
        copy(route = transform(route))

}

fun Route.hasJourneyLongerThan(duration: Duration) =
    any { it.duration > duration }