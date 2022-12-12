package com.example.travelator.actiontocalculation.version3;

import java.util.Set;

public interface Trips {
	Set<Trip> currentTripsFor(String customerId);
}
