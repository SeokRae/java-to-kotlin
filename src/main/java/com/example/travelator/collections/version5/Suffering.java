package com.example.travelator.collections.version5;

import java.util.List;

import static com.example.travelator.collections.version4.Collections.sorted;
import static java.util.Comparator.comparing;

public class Suffering {
	
	public static int sufferScoreFor(
		// 경로를 표현
		List<Journey> route
	) {
		return sufferScore(
			longestJourneysIn(route, 3),
			getDepartsFrom(route));
	}
	
	private static List<Journey> longestJourneysIn(
		List<Journey> journeys,
		int limit
	) {
		// 경로를 길이 순으로 정렬
		var actualLimit = Math.min(journeys.size(), limit);
		return sorted(
			journeys,
			comparing(Journey::getDuration).reversed()
		).subList(0, actualLimit);
	}
	
	private static Location getDepartsFrom(List<Journey> route) {
		return route.get(0).getDepartsFrom();
	}
	
	/**
	 * 데이터를 제 자리에서 변경하는 코드 -> 새로운 값을 계산하고 참조가 이 새 값을 가리키게 하는 코드로 변경
	 */
	public static List<List<Journey>> routesToShowFor(String itineraryId) {
		return bearable(routesFor(itineraryId));
	}
	
	/**
	 *
	 */
	private static List<List<Journey>> bearable(
		List<List<Journey>> routes
	) {
		return routes.stream()
			.filter(route -> sufferScoreFor(route) <= 10)
			.toList();
	}
	
	private static List<List<Journey>> routesFor(String itineraryId) {
		return List.of();
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
