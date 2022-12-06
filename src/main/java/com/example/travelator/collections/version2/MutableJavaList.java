package com.example.travelator.collections.version2;

import java.util.ArrayList;
import java.util.List;

public class MutableJavaList {
	public static List<String> mutableListOfStrings(String... str) {
		return new ArrayList<>(List.of(str));
	}
}
