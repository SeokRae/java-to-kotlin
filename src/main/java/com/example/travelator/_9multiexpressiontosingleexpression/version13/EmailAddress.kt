package com.example.travelator._9multiexpressiontosingleexpression.version13

data class EmailAddress(
    val localPart: String,
    val domain: String,
) {
    override fun toString(): String = "$localPart@$domain"

    companion object {
        @JvmStatic
        fun parse(value: String): EmailAddress =
            // convert expression body to single expression
            value.lastIndexOf("@").let { atIndex ->
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