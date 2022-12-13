package com.example.travelator.actiontocalculation.version4;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.time.Instant;

import static java.net.HttpURLConnection.*;

public class CurrentTripsHandler {
	private final ITrackTrips tracking;
	private final ObjectMapper objectMapper = new ObjectMapper();
	
	public CurrentTripsHandler(ITrackTrips tracking) {
		this.tracking = tracking;
	}
	
	public Response handle(Request request) {
		try {
			var customerId = request.getQueryParam("customerId").stream()
				.findFirst();
			if (customerId.isEmpty()) {
				return new Response(HTTP_BAD_REQUEST);
			}
			var currentTrip = tracking.currentTripFor(
				customerId.get(),
				Instant.now());
			
			return currentTrip.isPresent() ?
				new Response(HTTP_OK, objectMapper.writeValueAsString(currentTrip))
				: new Response(HTTP_NOT_FOUND);
			
		} catch (Exception e) {
			return new Response(HTTP_INTERNAL_ERROR);
		}
	}
}
