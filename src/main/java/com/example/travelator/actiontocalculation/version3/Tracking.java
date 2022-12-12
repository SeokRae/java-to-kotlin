package com.example.travelator.actiontocalculation.version3;


import java.util.Optional;

import static com.example.travelator.actiontocalculation.version3.Trip.BookingStatus.BOOKED;


public class Tracking implements ITrackTrips {
	private final Trips trips;
	
	public Tracking(Trips trips) {
		this.trips = trips;
	}
	
	@Override
	public Optional<Trip> currentTripFor(String customerId) {
		var candidates = trips.currentTripsFor(customerId).stream() // 사용자 ID 로 현재 여행을 찾는다.
			.filter((trip) -> trip.getBookingStatus() == BOOKED) // 예약된 여행만 선택한다.
			.toList();
		if (candidates.size() == 1) {
			return Optional.of(candidates.get(0));
		} else if (candidates.size() == 0) {
			return Optional.empty();
		} else {
			throw new IllegalStateException("Unexpected more than one current trip for " + customerId);
		}
	}
}
