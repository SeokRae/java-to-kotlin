package com.example.travelator.collections.version3

/**
 * 불변 객체
 */
class AValueType(
    // kotlin.collections.List 불변 컬렉션
    val strings: List<String>,
) {
    val first: String? = strings.firstOrNull()
}