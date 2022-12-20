package com.example.travelator._9multiexpressiontosingleexpression.version2

data class EmailAddress(
    val localPart: String,
    val domain: String,
) {
    override fun toString(): String = "$localPart@$domain"

    // 인라이닝이라는 기법을 알려주기위한 미친 코드
    companion object {
        @JvmStatic
        fun parse(value: String): EmailAddress {
            require(
                !(value.lastIndexOf("@") < 1
                        || value.lastIndexOf("@") == value.length - 1)
            ) {
                "Invalid email address: $value"
            }
            return EmailAddress(
                value.substring(0, value.lastIndexOf("@")),
                value.substring(value.lastIndexOf("@") + 1)
            )
        }
    }

}