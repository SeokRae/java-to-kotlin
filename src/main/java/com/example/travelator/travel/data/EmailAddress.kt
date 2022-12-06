package com.example.travelator.travel.data

/**
 *  data class로 equals & hashCode를 줄일 수 있었지만?
 *  1. 캡슐화를 지킬 수 없다는 문제
 *  2. equals & hashCode & toString을 자동 생성
 *  3. 컴파일러가 데이터 클래스 객체의 모든 프로퍼티 값을 그대로 복사한 새 객체를 생성하되,
 *      원하면 일부를 다른 값으로 대치할 수 있는 copy 메서드도 생성
 *
 */
data class EmailAddress(
    val localPart: String,
    val domain: String,
) {

    override fun toString(): String {
        return "$localPart@$domain"
    }

    companion object {
        @JvmStatic
        fun parse(value: String): EmailAddress {
            val atIndex = value.lastIndexOf("@")
            require(!(atIndex < 1 || atIndex == value.length - 1)) { "Invalid email address: $value" }
            return EmailAddress(
                value.substring(0, atIndex),
                value.substring(atIndex + 1)
            )
        }
    }
}