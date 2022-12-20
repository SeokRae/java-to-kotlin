package com.example.travelator._9multiexpressiontosingleexpression.version12

data class EmailAddress(
    val localPart: String,
    val domain: String,
) {
    override fun toString(): String = "$localPart@$domain"

    companion object {
        @JvmStatic
        fun parse(value: String): EmailAddress {
            // 인라이닝으로 단일식으로 변경
            return value.lastIndexOf("@").let { atIndex -> // 람다 파라미터 지정하여 지역변수가 아닌 람다 파라미터 사용
                require(!(atIndex < 1 || atIndex == value.length - 1)) {
                    "Invalid email address: $value"
                }
                EmailAddress(
                    value.substring(0, atIndex),
                    value.substring(atIndex + 1)
                )
            }
        }
    }
}