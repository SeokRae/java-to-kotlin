package com.example.travelator.collections.version3

import com.example.travelator.collections.version2.SomeJavaCode
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class AValueTypeTest {
    @DisplayName("AValueType의 first 프로퍼티는 strings의 첫번째 요소를 반환한다.")
    @Test
    fun testCase1() {
        // given
        val aValueType = AValueType(listOf("0", "1", "2"))

        // when
        val actual = aValueType.first
        val expected = aValueType.strings.first()

        // then
        assertThat(actual).isEqualTo(expected)
    }

    @DisplayName(
        """
        기대 값은 '0', 실제 banana
        """
    )
    @Test
    fun testCase2() {
        // given
        val aList: List<String> = SomeJavaCode.mutableListOfStrings("0", "1", "2") // 가변
        val holdState = AValueType(aList)

        // when
        val aMutableList: MutableList<String> = aList as MutableList<String> // 다운 캐스팅 (이런식의 다운 캐스팅하면 안됨)
        aMutableList[0] = "banana"

        // then
        assertThat(holdState.first).isEqualTo(holdState.strings.first())
    }

    @DisplayName(
        """
        기대값은 0인데 실제는 banana
    """
    )
    @Test
    fun testCase3() {
        val aMutableList: MutableList<String> = mutableListOf("0", "1", "2") // 가변 컬렉션
        println("aMutableList = ${aMutableList.hashCode()}")
        val aList: List<String> = aMutableList // 코틀린 List

        val holdState = AValueType(aList) // 변경이 가능한 객체임을 확인하는 테스트
        println("holdState = ${holdState.hashCode()}")
        aMutableList[0] = "banana"

        aMutableList.forEach(::println)
        holdState.let { println("holdState = ${it.first}") }
        assertThat(holdState.strings.first()).isEqualTo(holdState.first)
    }
}