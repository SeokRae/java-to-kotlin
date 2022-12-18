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
    fun `test case2`() {
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
        기대값은 0인데 실제는 banana 다!! 라는 결과 값이 나와야 하는데?
        """
    )
    @Test
    fun `test case3`() {
        val aMutableList: MutableList<String> = mutableListOf("0", "1", "2") // 가변 컬렉션
        println("aMutableList = ${aMutableList.javaClass}")

        val aList: List<String> = aMutableList // 가변 컬렉션을 코틀린 List(불변 컬렉션)으로 변환
        println("aList = ${aList.javaClass}")

        val holdState = AValueType(aList) // 불변 컬렉션으로 반환 할거라 기대했는데 ? 가변 컬렉션으로 반환됨
        println("holdState.strings = ${holdState.strings.javaClass}")
        aMutableList[0] = "banana" // 참조 컬렉션에 0번 인덱스의 값을 변경

        assertThat(aList[0]).isEqualTo("banana") // 불변 컬렉션의 0번 인덱스의 값이 banana로 변경되었네? -> 책에서 의도한 불변 컬렉션의 특성이 깨짐

        assertThat(holdState.first).isEqualTo(holdState.strings.first())
//        assertEquals( holdState.first, holdState.strings.first())
    }
}