package com.example.travelator.optional.java;

import java.time.Duration;
import java.util.Optional;

public class Leg {
	private final String name;
	private final Duration plannedDuration;
	
	private Leg(String name, Duration plannedDuration) {
		this.name = name;
		this.plannedDuration = plannedDuration;
	}
	
	public static Leg leg(String name, Duration duration) {
		return new Leg(name, duration);
	}
	
	public Duration getPlannedDuration() {
		return plannedDuration;
	}
	
	public String getName() {
		return name;
	}
	
	public String getDescription() {
		return name;
	}
}
