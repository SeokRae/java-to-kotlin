package com.example.travelator._18opentosealed.origin.itinerary

import com.example.travelator._18opentosealed.origin.Id
import com.example.travelator._18opentosealed.origin.geo.OverlayGroup
import com.example.travelator._18opentosealed.origin.geo.mapOverlay

data class Itinerary(
    val id: Id<Itinerary>,
    val items: List<ItineraryItem>
) : Iterable<ItineraryItem> by items

val Itinerary.mapOverlay: OverlayGroup
    get() = OverlayGroup(
        id = id,
        elements = items.map { it.mapOverlay }
    )

val Itinerary.costs
    get() = flatMap(ItineraryItem::costs)