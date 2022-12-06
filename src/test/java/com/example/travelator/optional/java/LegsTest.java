package com.example.travelator.optional.java;

import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.util.List;
import java.util.Optional;

import static com.example.travelator.optional.java.Leg.leg;
import static com.example.travelator.optional.java.Legs.findLongestLegOver;
import static java.util.Collections.emptyList;
import static org.assertj.core.api.Assertions.assertThat;

class LegsTest {
	
	private final List<Leg> legs = List.of(
		leg("one hour", Duration.ofHours(1)),
		leg("one day", Duration.ofDays(1)),
		leg("two hour", Duration.ofHours(2))
	);
	
	private final Duration oneDay = Duration.ofDays(1);
	
	@Test
	void is_absent_when_no_legs() {
		Optional<Leg> longestLegOver = findLongestLegOver(emptyList(), Duration.ZERO);
		assertThat(longestLegOver).isEmpty();
	}
	
	@Test
	void is_absent_when_no_legs_enough() {
		assertThat(findLongestLegOver(legs, oneDay)).isEmpty();
	}
	
	@Test
	void is_longest_leg_when_one_match() {
		String actual = findLongestLegOver(legs, oneDay.minusMillis(1))
			.orElseThrow().getDescription();
		assertThat(actual).isEqualTo("one day");
	}
	
	@Test
	void is_longest_leg_when_more_than_one_match() {
		String actual = findLongestLegOver(legs, Duration.ofMinutes(59))
			.orElseThrow().getDescription();
		assertThat(actual).isEqualTo("one day");
	}
}