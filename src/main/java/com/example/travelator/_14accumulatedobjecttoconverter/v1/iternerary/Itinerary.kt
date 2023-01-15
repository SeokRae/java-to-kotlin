package com.example.travelator._14accumulatedobjecttoconverter.v1.iternerary

import com.example.travelator._14accumulatedobjecttoconverter.v1.Id

data class Itinerary(
    val id: Id<Itinerary>,
    val route: Route,
    val accommodations: List<Accommodation> = emptyList(),
) {
    fun addCostsTo(calculator: CostSummaryCalculator) {
        route.addCostsTo(calculator)
        accommodations.addCostsTo(calculator)
    }
    private fun Iterable<Accommodation>.addCostsTo(calculator: CostSummaryCalculator) {
        forEach { it.addCostsTo(calculator) }
    }
}
