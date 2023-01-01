package com.example.travelator._11methodtoproperty.v11.kotlin

fun Iterable<CampSite>.sitesInRegion(
    countryISO: String,
    region: String,
): Set<CampSite> =
    filter { site ->
        site.countryCode == countryISO
                && site.region.equals(region, ignoreCase = true)
    }.toSet()