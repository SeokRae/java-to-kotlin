package com.example.travelator.abstractinsteadcomposition.kotlin

class FooImpl : Foo {
    override val message: String = "Message of FooImpl"

    override fun print() {
        println(message)
    }
}