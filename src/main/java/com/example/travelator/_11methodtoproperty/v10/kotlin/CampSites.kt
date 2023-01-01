package com.example.travelator._11methodtoproperty.v10.kotlin;

import java.util.Set;
import java.util.stream.Collectors;

public class CampSites {
	
	public static Set<CampSite> sitesInRegion(
		Set<CampSite> sites,
		String countryISO,
		String region
	) {
		return sites.stream()
				.filter(campSite ->
					campSite.getCountryCode().equals(countryISO)
					&& campSite.getRegion().equalsIgnoreCase(region)
				)
				.collect(Collectors.toUnmodifiableSet());
	}
}
