package com.example.travelator.actiontocalculation.version3;

import java.util.Optional;

public interface ITrackTrips {
	Optional<Trip> currentTripFor(String customerId);
}
