package com.example.travelator._18opentosealed.origin.itinerary;

public class ItineraryItems {
	public static void example(ItineraryItem item) {
		if (item instanceof Journey journey) {
		} else if (item instanceof Accommodation accommodation) {
		} else if (item instanceof RestaurantBooking restaurant) {
		} else {
			throw new IllegalStateException("should never happen");
		}
	}
}