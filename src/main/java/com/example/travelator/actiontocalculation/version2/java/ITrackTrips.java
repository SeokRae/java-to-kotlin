package com.example.travelator.actiontocalculation.version2.java;

import java.util.Optional;

public interface ITrackTrips {
	Optional<Trip> currentTripFor(String customerId);
}
