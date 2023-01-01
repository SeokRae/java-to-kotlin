package com.example.travelator._11methodtoproperty.v11.kotlin

import java.util.stream.Collectors

fun sitesInRegion(
    sites: Set<CampSite>,
    countryISO: String,
    region: String?
): Set<CampSite> {
    return sites.stream()
        .filter { campSite: CampSite ->
            campSite.countryCode == countryISO
                    && campSite.region.equals(region, ignoreCase = true)
        }
        .collect(Collectors.toUnmodifiableSet())
}