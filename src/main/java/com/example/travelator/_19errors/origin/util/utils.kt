package com.example.travelator._19errors.origin.util

import java.util.*

fun <T> T?.toOptional(): Optional<T & Any> = Optional.ofNullable(this)