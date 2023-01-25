package com.example.travelator._16interfacestofuns.origin.recommendations

import com.example.travelator._16interfacestofuns.origin.destinations.FeaturedDestination
import com.example.travelator._16interfacestofuns.origin.domain.Location

data class FeaturedDestinationSuggestion(
    val routeLocation: Location,
    val suggestion: FeaturedDestination,
    val distanceMeters: Int
)