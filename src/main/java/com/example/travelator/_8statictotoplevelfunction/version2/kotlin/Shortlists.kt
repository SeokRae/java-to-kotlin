@file:JvmName("Shortlists")

package com.example.travelator._8statictotoplevelfunction.version2.kotlin

import com.example.travelator._8statictotoplevelfunction.origin.HasPrice
import com.example.travelator._8statictotoplevelfunction.origin.HasRating
import java.util.stream.Stream

fun <T> sorted(shortlist: List<T>, ordering: Comparator<in T>?): List<T> {
    return shortlist.stream()
        .sorted(ordering)
        .toList()
}

fun <T> removeItemAt(shortlist: List<T>, index: Int): List<T> {
    return Stream.concat(
        shortlist.stream().limit(index.toLong()),  // index 만큼 스트림을 substream으로 만들어서 앞에 붙임
        shortlist.stream().skip(index.toLong() + 1) // index + 1부터 스트림을 substream으로 만들어서 뒤에 붙임
    ).toList()
}


fun byRating(): Comparator<HasRating> {
    return Comparator.comparingDouble(HasRating::rating).reversed()
}


fun byPriceLowToHigh(): Comparator<HasPrice> {
    return Comparator.comparing(HasPrice::price)
}