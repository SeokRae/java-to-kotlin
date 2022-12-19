package com.example.travelator._8statictotoplevelfunction.version1.kotlin

import com.example.travelator._8statictotoplevelfunction.origin.HasPrice
import com.example.travelator._8statictotoplevelfunction.origin.HasRating
import java.util.stream.Stream

/**
 * 정적 메서드를 최상위 수준 함수로 변환을 했으나 최상위 클래스만을 생성할 뿐
 * @JvmStatic 까지는 만들지 못함
 */
object Shortlists {
    @JvmStatic
    fun <T> sorted(shortlist: List<T>, ordering: Comparator<in T>?): List<T> {
        return shortlist.stream()
            .sorted(ordering)
            .toList()
    }

    @JvmStatic
    fun <T> removeItemAt(shortlist: List<T>, index: Int): List<T> {
        return Stream.concat(
            shortlist.stream().limit(index.toLong()),  // index 만큼 스트림을 substream으로 만들어서 앞에 붙임
            shortlist.stream().skip(index.toLong() + 1) // index + 1부터 스트림을 substream으로 만들어서 뒤에 붙임
        ).toList()
    }

    @JvmStatic
    fun byRating(): Comparator<HasRating> {
        return Comparator.comparingDouble(HasRating::rating).reversed()
    }

    @JvmStatic
    fun byPriceLowToHigh(): Comparator<HasPrice> {
        return Comparator.comparing(HasPrice::price)
    }
}