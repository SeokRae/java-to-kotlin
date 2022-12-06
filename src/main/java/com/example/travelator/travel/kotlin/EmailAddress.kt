package com.example.travelator.travel.kotlin

import java.util.*

class EmailAddress(
    val localPart: String,
    val domain: String,
) {

    override fun equals(o: Any?): Boolean {
        if (this === o) return true
        if (o == null || javaClass != o.javaClass) return false
        val that = o as EmailAddress
        return localPart == that.localPart && domain == that.domain
    }

    override fun hashCode(): Int {
        return Objects.hash(localPart, domain)
    }

    override fun toString(): String {
        return "$localPart@$domain"
    }

    companion object { // 동반객체 ? (정적 상태와 메서드를 포함시키기 위해 사용)
        @JvmStatic
        fun parse(value: String): EmailAddress {
            val atIndex = value.lastIndexOf("@")
            require(!(atIndex < 1 || atIndex == value.length - 1)) { "Invalid email address: $value" }
            return EmailAddress(
                value.substring(0, atIndex),
                value.substring(atIndex + 1)
            )
        }
    }
}