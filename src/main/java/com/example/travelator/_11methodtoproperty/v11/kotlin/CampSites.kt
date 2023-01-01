package com.example.travelator._11methodtoproperty.v11.kotlin

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

private fun CampSite.isIn(
    countryISO: String,
    region: String? = null,
) = when(region) {
    null -> countryCode == countryISO
    else -> countryCode == countryISO
            && this.region.equals(region, ignoreCase = true)
}