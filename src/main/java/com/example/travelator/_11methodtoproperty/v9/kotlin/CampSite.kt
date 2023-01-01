package com.example.travelator._11methodtoproperty.v9.kotlin

import com.example.travelator._11methodtoproperty.v9.java.Address

/**
 * 필드가 뒷받침하는 프로퍼티는 생성자 프로퍼티가 됐고,
 */
data class CampSite(
    val id: String,
    val name: String,
    val address: Address,
) {
    // 컨벤션이 지켜진 getter의 경우 생성자 프로퍼티로 변환 됨
    val countryCode: String
        get() = address.countryCode

    // region은 프로퍼티라는 사실을 인식하지 못해서 단순 메서드로 취급해 변환하게 됨
    fun region(): String {
        return address.region
    }
}