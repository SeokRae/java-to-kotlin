package com.example.travelator._9multiexpressiontosingleexpression.version10

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