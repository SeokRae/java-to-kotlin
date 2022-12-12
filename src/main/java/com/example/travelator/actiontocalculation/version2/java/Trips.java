package com.example.travelator.actiontocalculation.version2.java;

import java.util.Set;

public interface Trips {
	Set<Trip> currentTripsFor(String customerId);
}
