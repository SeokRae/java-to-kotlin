package com.example.travelator.actiontocalculation.version5

import java.time.Clock
import java.time.Instant
import java.util.stream.Collectors

class InMemoryTrips(clock: Clock) : Trips {
    private val trips: MutableMap<String, MutableSet<Trip>>
    private val clock: Clock

    init {
        trips = HashMap()
        this.clock = clock
    }

    fun addTrip(trip: Trip) {
        val existingTrips = trips.getOrDefault(trip.customerId, LinkedHashSet())
        existingTrips.add(trip)
        trips.putIfAbsent(trip.customerId, existingTrips)
        //		trips.computeIfAbsent(trip.getCustomerId(), (id) -> new LinkedHashSet<>()).add(trip);
    }

    override fun currentTripsFor(customerId: String, at: Instant): Set<Trip> {
        return tripsFor(customerId).stream()
            .filter { trip: Trip -> trip.isPlannedToBeActiveAt(at) }
            .collect(Collectors.toSet())
    }

    private fun tripsFor(customerId: String): Collection<Trip> {
        return trips.getOrDefault(customerId, emptySet())
    }
}