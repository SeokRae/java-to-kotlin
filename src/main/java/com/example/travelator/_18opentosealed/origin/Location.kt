package com.example.travelator._18opentosealed.origin

import com.example.travelator._18opentosealed.origin.geo.Position


data class Location(
    val id: Id<Location>,
    val localName: String,
    val userReadableName: String,
    val position: Position
)