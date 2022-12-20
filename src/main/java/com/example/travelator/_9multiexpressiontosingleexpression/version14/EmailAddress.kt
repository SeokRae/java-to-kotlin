package com.example.travelator._9multiexpressiontosingleexpression.version14

data class EmailAddress(
    val localPart: String,
    val domain: String,
) {
    override fun toString(): String = "$localPart@$domain"

    companion object {
        @JvmStatic
        fun parse(value: String): EmailAddress {
            val (leftPart, rightPart) = split(value)
            // 로컬 변수로 분리 후 메서드로 추출
            return EmailAddress(
                leftPart,
                rightPart
            )
        }

        // 추출된 메서드는 Pair를 반환되도록 처리됨
        private fun split(value: String): Pair<String, String> {
            val atIndex = value.lastIndexOf("@")
            require(!(atIndex < 1 || atIndex == value.length - 1)) {
                "Invalid email address: $value"
            }
            val leftPart = value.substring(0, atIndex)
            val rightPart = value.substring(atIndex + 1)
            return Pair(leftPart, rightPart)
        }
    }
}