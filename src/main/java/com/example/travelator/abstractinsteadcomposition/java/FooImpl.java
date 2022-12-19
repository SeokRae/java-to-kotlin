package com.example.travelator.abstractinsteadcomposition.java;

public class FooImpl implements Foo {
	
	@Override
	public String message() {
		return "Message of FooImpl";
	}
	
	@Override
	public void print() {
		System.out.println(message());
	}
}
