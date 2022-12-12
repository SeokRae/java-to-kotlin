package com.example.travelator.actiontocalculation.version3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.Instant;
import java.util.Optional;

import static com.example.travelator.actiontocalculation.version3.Trip.BookingStatus.BOOKED;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class TrackingTest {
	
	private StoppedClock clock;
	private InMemoryTrips trips;
	private Tracking tracking;
	
	@BeforeEach
	void setUp() {
		clock = new StoppedClock();
		trips = new InMemoryTrips(clock);
		tracking = new Tracking(trips);
	}
	
	@DisplayName("계획된 여행이 없으면 빈 목록을 반환한다")
	@Test
	void returns_empty_when_no_trip_planned_to_happen_now() {
		Optional<Trip> actual = tracking.currentTripFor("customer", anInstant());
		
		assertThat(actual).isEmpty();
	}
	
	@Test
	void returns_single_active_booked_trip() {
		Trip diwaliTrip = givenATrip("cust1", "Diwali", "2022-11-13", "2022-11-15", BOOKED);
		givenATrip("cust1", "Christmas", "2022-12-24", "2022-11-16", BOOKED);
		
		Optional<Trip> actual = tracking.currentTripFor("cust1", diwaliTrip.getPlannedStartTime().toInstant());
		
		assertThat(actual).isEqualTo(Optional.of(diwaliTrip));
	}
	
	private Trip givenATrip(String customerId,
	                        String name,
	                        String startDate,
	                        String endDate,
	                        Trip.BookingStatus bookingStatus) {
		Trip trip = new Trip(
			"ignoredId",
			customerId,
			name,
			TimeUtils.zonedDateTime(startDate + "T12:00:00+00:00[Europe/London]"),
			TimeUtils.zonedDateTime(endDate + "T12:00:00+00:00[Europe/London]"),
			bookingStatus
		);
		trips.addTrip(trip);
		return trip;
	}
	
	private Instant anInstant() {
		return clock.now;
	}
}