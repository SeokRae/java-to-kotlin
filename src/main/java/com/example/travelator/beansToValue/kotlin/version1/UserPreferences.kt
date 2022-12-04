package com.example.travelator.beansToValue.kotlin.version1

import java.util.*

/**
 * 코틀린 변환 1차 버전
 */
class UserPreferences
// 컴파일러가 greeting, locale, currency의 디폴트 값들을 서로 조합한(경우의 수) 여러 생성자를 만들어내도록 지정
@JvmOverloads constructor(
    var greeting: String = "Hello",
    var locale: Locale = Locale.UK,
    var currency: Currency = Currency.getInstance(Locale.UK)
)