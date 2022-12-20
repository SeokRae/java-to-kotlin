package com.example.travelator._9multiexpressiontosingleexpression.version17

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

    }
}

// when이 더 깔끔하다고 하지 않았나. version8에서는 when을 사용했었다.
private fun String.split(divider: Char): Pair<String, String> =
    lastIndexOf(divider).let { index ->
        // require 보다 if 문으로 하는게 좋다 하지 않았나
        require(index >= 1 && index != length - 1) {
            "string must be two non-empty parts seperated by $divider"
        }
        // to 문법은 또 뭔데
        substring(0, index) to substring(index + 1)
    }