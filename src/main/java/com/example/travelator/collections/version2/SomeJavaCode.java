package com.example.travelator.collections.version2;

import java.util.ArrayList;
import java.util.List;

public class SomeJavaCode {
	public static List<String> mutableListOfStrings(String... str) {
		return new ArrayList<>(List.of(str));
	}
}
