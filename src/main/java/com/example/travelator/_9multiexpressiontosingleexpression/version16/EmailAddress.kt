package com.example.travelator._9multiexpressiontosingleexpression.version16

data class EmailAddress(
    val localPart: String,
    val domain: String,
) {
    override fun toString(): String = "$localPart@$domain"

    companion object {
        @JvmStatic
        fun parse(value: String): EmailAddress = // parse 단일식 함수로 변경
            value.split('@').let { (leftPart, rightPart) ->
                EmailAddress(leftPart, rightPart)
            }

        // 추출된 메서드는 Pair를 반환되도록 처리됨
        private fun String.split(divider: Char): Pair<String, String> {
            val atIndex = lastIndexOf(divider)
            require(!(atIndex < 1 || atIndex == length - 1)) {
                "EmailAddress must be two parts seperated by @"
            }
            val leftPart = substring(0, atIndex)
            val rightPart = substring(atIndex + 1)
            return Pair(leftPart, rightPart)
        }
    }
}