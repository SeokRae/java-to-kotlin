package com.example.travelator._8statictotoplevelfunction.origin.java;

import com.example.travelator._8statictotoplevelfunction.origin.ExampleItem;
import org.junit.jupiter.api.Test;

import java.util.List;

import static com.example.travelator.collections.version4.Collections.sorted;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ShortlistsTest {
	ExampleItem a = new ExampleItem("A", 4.0f, 500, 0.25);
	ExampleItem b = new ExampleItem("B", 2.5f, 250, 0.75);
	ExampleItem c = new ExampleItem("C", 4.8f, 300, 0.5);
	ExampleItem d = new ExampleItem("D", 3.5f, 480, 0.8);
	
	List<ExampleItem> items = shortlistOf(a, b, c, d);
	
	@Test
	void cheapest() {
		var reordered = sorted(items, com.example.travelator._8statictotoplevelfunction.origin.kotlin.ShortlistsKt.byPriceLowToHigh());
		
		assertEquals(shortlistOf(b, c, d, a), reordered);
	}
	
	@Test
	void topRated() {
		assertEquals(shortlistOf(c, a, d, b), sorted(items, com.example.travelator._8statictotoplevelfunction.origin.kotlin.ShortlistsKt.byRating()));
	}
	
	@Test
	void bestValue() {
		var reordered = sorted(items, com.example.travelator._8statictotoplevelfunction.origin.kotlin.ShortlistsKt.byValue());
		
		assertEquals(shortlistOf(c, b, a, d), reordered);
	}
	
	@Test
	void mostRelevant() {
		assertEquals(shortlistOf(d, b, c, a), sorted(items, com.example.travelator._8statictotoplevelfunction.origin.kotlin.ShortlistsKt.byRelevance()));
	}
	
	private List<ExampleItem> shortlistOf(ExampleItem... items) {
		return List.of(items);
	}
}