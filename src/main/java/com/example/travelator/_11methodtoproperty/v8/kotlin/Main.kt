package com.example.travelator._11methodtoproperty.v8.kotlin


fun main() {
    println("Hello, World! ${A(3).a}")
}

val a by lazy { 3 }

class A(private val v: Int) {
    operator fun plus(b: A): A {
        return A(v + b.v)
    }
}

fun A.add(b: A) = this + b
val A.a by lazy { 5 }