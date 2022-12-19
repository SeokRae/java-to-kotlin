package com.example.travelator.abstractinsteadcomposition.kotlin

class Bar(foo: Foo) : Foo by foo {
    override val message = "Message of Bar"
}