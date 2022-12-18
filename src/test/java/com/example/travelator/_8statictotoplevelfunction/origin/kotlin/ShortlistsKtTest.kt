package com.example.travelator._8statictotoplevelfunction.origin.kotlin

import com.example.travelator._8statictotoplevelfunction.origin.ExampleItem
import com.example.travelator._8statictotoplevelfunction.origin.java.Collections.sorted
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test


class ShortlistsKtTest {
    private var a = ExampleItem("A", 4.0, 500, 0.25)
    private var b = ExampleItem("B", 2.5, 250, 0.75)
    private var c = ExampleItem("C", 4.8, 300, 0.5)
    private var d = ExampleItem("D", 3.5, 480, 0.8)
    private var items = shortlistOf(a, b, c, d)

    @Test
    fun cheapest() {
        // 무슨차이 인지 확인 필요
        // Unit -> MutableList<ExampleItem>?
        val actual: MutableList<ExampleItem>? = sorted(items, byPriceLowToHigh())
        val expected = shortlistOf(b, c, d, a)

        assertThat(actual).isEqualTo(expected)
    }

    @Test
    fun topRated() {
        val actual = sorted(items, byRating())

        val expected = shortlistOf(c, a, d, b)
        assertThat(actual).isEqualTo(expected)
    }

    @Test
    fun bestValue() {
        val actual: MutableList<ExampleItem>? = sorted(items, byValue())

        val expected = shortlistOf(c, b, a, d)

        assertThat(actual).isEqualTo(expected)
    }

    @Test
    fun mostRelevant() {
        assertEquals(shortlistOf(d, b, c, a), sorted(items, byRelevance()))
    }

    private fun shortlistOf(vararg items: ExampleItem): List<ExampleItem> {
        return java.util.List.of(*items)
    }
}