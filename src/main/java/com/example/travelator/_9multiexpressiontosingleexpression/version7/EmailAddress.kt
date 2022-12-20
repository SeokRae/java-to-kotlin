package com.example.travelator._9multiexpressiontosingleexpression.version7

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
        ): EmailAddress = // return 에서 convert to expression body
            if ((atIndex < 1 || atIndex == value.length - 1)) {
                throw IllegalArgumentException(
                    "EmailAddress must be two parts seperated by @"
                )
            } else {
                EmailAddress(
                    value.substring(0, atIndex),
                    value.substring(atIndex + 1)
                )
            }
    }
}