package com.example.travelator.travel.kotlin

object Marketing {
    fun isHotMailAddress(emailAddress: EmailAddress): Boolean {
        return emailAddress.domain // 자바의 getter 메서드 호출하는 방식이 아닌 프로퍼티에 접근한다는 개념
            .equals("hotmail.com", ignoreCase = true)
    }
}