package com.example.travelator.abstractinsteadcomposition.java;

public class Bar implements Foo {
	private final Foo foo;
	
	public Bar(Foo foo) {
		this.foo = foo;
	}
	
	@Override
	public String message() {
		return "Message of Bar";
	}
	
	@Override
	public void print() {
		foo.print();
	}
}
