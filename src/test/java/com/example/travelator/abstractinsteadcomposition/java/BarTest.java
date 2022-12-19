package com.example.travelator.abstractinsteadcomposition.java;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class BarTest {
	
	@Test
	void testCase1() {
		FooImpl foo = new FooImpl();
		Bar bar = new Bar(foo);
		bar.print();
		assertThat(bar.message()).isEqualTo("Message of Bar");
		
	}
}