package com.example.travelator._9multiexpressiontosingleexpression.version4

data class EmailAddress(
    val localPart: String,
    val domain: String,
) {
    override fun toString(): String = "$localPart@$domain"

    /**
     * 1. Extract Method
     * 2. Inlining
     */
    companion object {
        @JvmStatic
        fun parse(value: String): EmailAddress { // 단일식으로 변환
            return emailAddress(value.lastIndexOf("@"), value) // extract method를 통한 리펙토링
        }

        /**
         * 갑자기 왜 if문이 됐지?
         */
        private fun emailAddress(
            atIndex: Int,
            value: String,
        ): EmailAddress { // 아직은 단일식이 아님
            if ((atIndex < 1 || atIndex == value.length - 1)) { // 단일식을 막는 문제는 require() 함수
                val message = "EmailAddress must be two parts seperated by @"
                throw IllegalArgumentException(message)
            }
            return EmailAddress(
                value.substring(0, atIndex),
                value.substring(atIndex + 1)
            )
        }
    }

}