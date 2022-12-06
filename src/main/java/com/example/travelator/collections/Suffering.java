package com.example.travelator.collections;

import java.util.List;

import static java.util.Comparator.comparing;

public class Suffering {
	
	public static int sufferScoreFor(
		// 경로를 표현
		List<Journey> route
	) {
		List<Journey> longestJourneys = longestJourneysIn(route, 3);
		return sufferScore(longestJourneys, getDepartsFrom(route));
	}
	
	private static int sufferScore(List<Journey> longestJourneys, Location start) {
		return 0;
	}
	
	private static List<Journey> longestJourneysIn(
		List<Journey> journeys,
		int limit
	) {
		journeys.sort(comparing(Journey::getDuration).reversed());
		int actualLimit = Math.min(journeys.size(), limit);
		return journeys.subList(0, actualLimit);
	}
	
	private static Location getDepartsFrom(List<Journey> route) {
		return route.get(0).getDepartsFrom();
	}
}
