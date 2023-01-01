package com.example.travelator._11methodtoproperty.v10.kotlin

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

    // convert function to property 변환하여 메서드 -> 생성자 프로퍼티로 변환
    val region: String
        get() {
            return address.region
        }
}