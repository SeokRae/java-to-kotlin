package com.example.travelator.collections;

import java.util.List;

public class Suffering {
	
	public static int sufferScoreFor(
		// 경로를 표현
		List<Journey> route
	) {
		List<Journey> longestJourneys = longestJourneys(route, 3);
		return sufferScore(longestJourneys, getDepartsFrom(route));
	}
	
	private static int sufferScore(List<Journey> longestJourneys, Location start) {
		return 0;
	}
	
	private static List<Journey> longestJourneys(List<Journey> route, int start) {
		return null;
	}
	
	private static Location getDepartsFrom(List<Journey> route) {
		return route.get(0).getDepartsFrom();
	}
}
