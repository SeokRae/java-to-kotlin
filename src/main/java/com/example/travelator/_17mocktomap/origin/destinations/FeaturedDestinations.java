package com.example.travelator._17mocktomap.origin.destinations;

import com.example.travelator._17mocktomap.origin.domain.Location;

import java.util.List;

public interface FeaturedDestinations {
	List<FeaturedDestination> findCloseTo(Location location);
	
	FeaturedDestination findClosest(Location location);
	
	FeaturedDestination add(FeaturedDestinationData destination);
	
	void remove(FeaturedDestination destination);
	
	void update(FeaturedDestination destination);
}