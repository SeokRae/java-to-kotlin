package com.example.travelator._8statictotoplevelfunction.version1.java;

import com.example.travelator._8statictotoplevelfunction.origin.HasPrice;
import com.example.travelator._8statictotoplevelfunction.origin.HasRating;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

import static java.util.Comparator.comparing;

public class Shortlists {
	
	private Shortlists() {
	}
	
	public static <T> List<T> sorted(List<T> shortlist, Comparator<? super T> ordering) {
		return shortlist.stream()
			.sorted(ordering)
			.toList();
	}
	
	public static <T> List<T> removeItemAt(List<T> shortlist, Integer index) {
		return Stream.concat(
			shortlist.stream().limit(index), // index 만큼 스트림을 substream으로 만들어서 앞에 붙임
			shortlist.stream().skip((long) index + 1) // index + 1부터 스트림을 substream으로 만들어서 뒤에 붙임
		).toList();
	}
	
	public static Comparator<HasRating> byRating() {
		return Comparator.comparingDouble(HasRating::getRating).reversed();
	}
	
	public static Comparator<HasPrice> byPriceLowToHigh() {
		return comparing(HasPrice::getPrice);
	}
	
}
