package com.example.travelator._11methodtoproperty.v12.kotlin

/**
 * 지역이 엔티티가 아니라 문자열일 뿐
 * 왜냐면 country를 string으로 갖고 있다면 동일한 다른 지역의 이름이 겹칠 수 있기 때문
 *
 */

fun Iterable<CampSite>.sitesInRegion(
    countryISO: String,
    region: String,
): Set<CampSite> =
    filter { site -> site.isIn(countryISO, region) }.toSet()

// isIn 같은 기초적인 연산을 Compsite에 대한 메서드로 진급도 가능
// 또는 Address의 메서드로 만들 수도 있음
private fun CampSite.isIn(
    countryISO: String,
    region: String? = null,
) = countryCode == countryISO &&
        region?.equals(this.region, ignoreCase = true) ?: true