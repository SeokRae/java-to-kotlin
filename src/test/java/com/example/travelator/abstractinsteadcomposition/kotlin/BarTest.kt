package com.example.travelator.abstractinsteadcomposition.kotlin

import org.junit.jupiter.api.Test

class BarTest {

    @Test
    fun testCase1() {
        val foo = FooImpl()
        val bar = Bar(foo)
        bar.print()
        println(bar.message)
    }
}