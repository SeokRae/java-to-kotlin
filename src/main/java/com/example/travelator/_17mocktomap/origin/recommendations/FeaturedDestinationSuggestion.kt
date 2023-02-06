package com.example.travelator._17mocktomap.origin.recommendations

import com.example.travelator._17mocktomap.origin.destinations.FeaturedDestination
import com.example.travelator._17mocktomap.origin.domain.Location

data class FeaturedDestinationSuggestion(
    val routeLocation: Location,
    val suggestion: FeaturedDestination,
    val distanceMeters: Int
)