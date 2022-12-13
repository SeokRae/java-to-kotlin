package com.example.travelator.actiontocalculation.version4;

import java.time.Clock;
import java.time.Instant;
import java.util.*;

import static java.util.stream.Collectors.toSet;

public class InMemoryTrips implements Trips {
	private final Map<String, Set<Trip>> trips;
	private final Clock clock;
	
	public InMemoryTrips(Clock clock) {
		this.trips = new HashMap<>();
		this.clock = clock;
	}
	
	void addTrip(Trip trip) {
		var existingTrips = trips.getOrDefault(trip.getCustomerId(), new LinkedHashSet<>());
		existingTrips.add(trip);
		trips.putIfAbsent(trip.getCustomerId(), existingTrips);
//		trips.computeIfAbsent(trip.getCustomerId(), (id) -> new LinkedHashSet<>()).add(trip);
	}
	
	@Override
	public Set<Trip> currentTripsFor(String customerId, Instant at) {
		return tripsFor(customerId).stream()
			.filter(trip -> trip.isPlannedToBeActiveAt(at))
			.collect(toSet());
	}
	
	private Collection<Trip> tripsFor(String customerId) {
		return trips.getOrDefault(customerId, Collections.emptySet());
	}
}
