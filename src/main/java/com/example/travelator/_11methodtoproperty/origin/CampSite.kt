package com.example.travelator._11methodtoproperty.origin

data class CampSite(
    val id: String,
    val name: String,
    val address: Address,
) {
    val countryCode: String
        get() = address.countryCode

    val region: String get() = address.region
}