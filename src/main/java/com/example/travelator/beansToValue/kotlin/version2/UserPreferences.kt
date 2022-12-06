package com.example.travelator.beansToValue.kotlin.version2

import java.util.*

/**
 * 코틀린 변환 2차 버전
 * class -> data class
 *
 * equals & hashCode를 구현해주기 때문에 가변 데이터 클래스를 사용하려는 경우 다른 가변 일반 클래스보다 주의가 필요
 *
 * 결론, 가변 데이터 클래스를 정의하지 말라
 */
data class UserPreferences
    (
    var greeting: String,
    var locale: Locale,
    var currency: Currency,
)