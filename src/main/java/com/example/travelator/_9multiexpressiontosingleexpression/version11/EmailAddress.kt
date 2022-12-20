package com.example.travelator._9multiexpressiontosingleexpression.version11

data class EmailAddress(
    val localPart: String,
    val domain: String,
) {
    override fun toString(): String = "$localPart@$domain"

    companion object {
        @JvmStatic
        fun parse(value: String): EmailAddress {
            val atIndex = value.lastIndexOf("@")
            return atIndex.let {
                // Name shadowed: atIndex
                    atIndex -> // 람다 파라미터 지정하여 지역변수가 아닌 람다 파라미터 사용
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