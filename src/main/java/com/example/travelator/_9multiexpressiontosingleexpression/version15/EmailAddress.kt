package com.example.travelator._9multiexpressiontosingleexpression.version15

data class EmailAddress(
    val localPart: String,
    val domain: String,
) {
    override fun toString(): String = "$localPart@$domain"

    companion object {
        @JvmStatic
        fun parse(value: String): EmailAddress {
            val (leftPart, rightPart) = value.split('@')
            // 로컬 변수로 분리 후 메서드로 추출
            return EmailAddress(
                leftPart,
                rightPart
            )
        }

        // 추출된 메서드는 Pair를 반환되도록 처리됨
        private fun String.split(divider: Char): Pair<String, String> { // convert parameter receiver
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