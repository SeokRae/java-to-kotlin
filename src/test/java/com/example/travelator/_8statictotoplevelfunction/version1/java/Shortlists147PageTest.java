package com.example.travelator._8statictotoplevelfunction.version1.java;

import com.example.travelator._8statictotoplevelfunction.origin.HasPrice;
import com.example.travelator._8statictotoplevelfunction.origin.HasRating;
import com.example.travelator._8statictotoplevelfunction.origin.HasRelevance;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

class Shortlists147PageTest {
	
	private List<HotelSearchResult> hotels;
	
	@BeforeEach
	void setUp() {
		HotelSearchResult theGrand = new HotelSearchResult(
			"The Grand",
			4.0f,
			500,
			0.25);
		HotelSearchResult theRitz = new HotelSearchResult(
			"The Ritz",
			2.5f,
			250,
			0.75);
		HotelSearchResult artHotel = new HotelSearchResult(
			"Art Hotel",
			0.6,
			300,
			0.5);
		hotels = List.of(theGrand, theRitz, artHotel);
	}
	
	@Test
	void testCase1() {

//		Shortlists.sorted(hotels, Shortlists.byValue());
	}
	
	record HotelSearchResult(
		String name,
		double relevance,
		int price,
		double rating
	) implements HasRelevance, HasPrice, HasRating {
		
		
		@Override
		public double getRating() {
			return rating;
		}
		
		@Override
		public double getRelevance() {
			return relevance;
		}
		
		@Override
		public int getPrice() {
			return price;
		}
	}
}