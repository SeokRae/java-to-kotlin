package com.example.travelator._12functiontooperator.v4

fun main() {
    println("Hello World! ${A(3) + A(2) * A(2)}")
    A(3).add(A(5))
}

val a by lazy{3}

class A(private val v:Int){
    fun add(b:A) = this + b
    operator fun plus(b:A):A{
        return A(v + b.v)
    }
    operator fun times(b:A):A{
        return A(v*b.a)
    }
}
val A.a by lazy { 5 }