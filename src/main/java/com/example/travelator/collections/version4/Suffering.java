package com.example.travelator.collections.version4;

import java.util.List;

import static com.example.travelator.collections.version4.Collections.sorted;
import static java.util.Comparator.comparing;

public class Suffering {
	
	public static int sufferScoreFor(
		// 경로를 표현
		List<Journey> route
	) {
		List<Journey> longestJourneys = longestJourneysIn(route, 3);
		return sufferScore(longestJourneys, getDepartsFrom(route));
	}
	
	private static List<Journey> longestJourneysIn(
		List<Journey> journeys,
		int limit
	) {
		var actualLimit = Math.min(journeys.size(), limit);
		return sorted(
			journeys,
			comparing(Journey::getDuration).reversed()
		).subList(0, actualLimit);
	}
	
	private static Location getDepartsFrom(List<Journey> route) {
		return route.get(0).getDepartsFrom();
	}
	
	public static List<List<Journey>> routesToShowFor(String itineraryId) {
		var routes = routesFor(itineraryId);
		removeUnbearableRoutes(routes);
		return routes;
	}
	
	private static List<List<Journey>> routesFor(String itineraryId) {
		return List.of();
	}
	
	private static void removeUnbearableRoutes(List<List<Journey>> routes) {
		routes.removeIf(route -> sufferScoreFor(route) > 10);
	}
	
	private static int sufferScore(
		List<Journey> longestJourneys,
		Location start
	) {
		return SOME_COMPLICATED_RESULT();
	}
	
	private static int SOME_COMPLICATED_RESULT() {
		return 0;
	}
}
