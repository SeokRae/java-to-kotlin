package com.example.travelator._8statictotoplevelfunction.origin.java;

import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;

public class Collections {
	
	private Collections() {
	}
	
	@SuppressWarnings("unchecked")
	public static <E> List<E> sorted(
		Collection<E> collection,
		Comparator<? super E> by
	) {
		var result = (E[]) collection.toArray();
		Arrays.sort(result, by);
		return Arrays.asList(result);
	}
}