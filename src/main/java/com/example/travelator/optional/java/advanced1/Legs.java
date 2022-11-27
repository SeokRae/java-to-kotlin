package com.example.travelator.optional.java.advanced1;

import com.example.travelator.optional.java.Leg;

import java.time.Duration;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class Legs {
	
	private Legs() {
	}
	
	public static Optional<Leg> findLongestLegOver(List<Leg> legs, Duration duration) {
		return legs.stream()
			.max(Comparator.comparing(Leg::getPlannedDuration))
			.filter(leg -> isLongerThan(leg, duration));
	}
	
	private static boolean isLongerThan(Leg leg, Duration duration) {
		return leg.getPlannedDuration().compareTo(duration) > 0;
	}
}
