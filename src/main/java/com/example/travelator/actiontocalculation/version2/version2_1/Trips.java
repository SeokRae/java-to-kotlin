package com.example.travelator.actiontocalculation.version2.version2_1;

import com.example.travelator.actiontocalculation.version2.java.Trip;

import java.time.Instant;
import java.util.Set;

public interface Trips {
	Set<Trip> currentTripsFor(String customerId, Instant at);
}
