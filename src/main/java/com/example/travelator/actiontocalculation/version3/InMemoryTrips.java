package com.example.travelator.actiontocalculation.version3;

import java.time.Clock;
import java.time.Instant;
import java.util.Optional;
import java.util.Set;

import static java.util.stream.Collectors.toSet;

public class InMemoryTrips implements Trips {
	private final Set<Trip> trips;
	private final Clock clock;
	
	public InMemoryTrips(Set<Trip> trips, Clock clock) {
		this.trips = trips;
		this.clock = clock;
	}
	
	@Override
	public Set<Trip> currentTripsFor(String customerId) {
		return tripsFor(customerId).stream()
			.filter(trip -> {
				Instant now = clock.instant();
				return trip.isPlannedToBeActiveAt(now);
			})
			.collect(toSet());
	}
	
	private Optional<Trip> tripsFor(String customerId) {
		return null;
	}
}
