package com.example.travelator.collections.version2

class SomeJavaCodePractice {
    fun testCase1() {
        val aList: List<String> = SomeJavaCode.mutableListOfStrings("0", "1", "2")
//        aList.removeAt("1");
    }

    /**
     * 코틀린은 MutableList 타입으로 변환 가능
     */
    fun testCase2() {
        val aList: MutableList<String> = SomeJavaCode.mutableListOfStrings("0", "2")
        val aMutableList = aList
        aMutableList.removeAt(1)
        if (aMutableList == aList) {
            println("aMutableList == List.of(\"0\", \"2\")")
        } else {
            println("Not Equals")
        }
    }

    fun testCase3() {
        // kotlin.collections.MutableList
        val aMutableList: MutableList<String> = mutableListOf("0", "1", "2")
        SomeJavaCode.needsAList(aMutableList)

        // kotlin.collections.List
        val aList: List<String> = listOf("0", "1", "2")
        SomeJavaCode.needsAList(aList)
    }
}

fun main() {
    SomeJavaCodePractice().testCase1()
    SomeJavaCodePractice().testCase2()
    SomeJavaCodePractice().testCase3()
}