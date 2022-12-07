package com.example.travelator.collections.version8;

import java.util.List;

public class Routes {
	
	public static Location getDepartsFrom(List<Journey> route) {
		return route.get(0).getDepartsFrom();
	}
	
}