package com.example.travelator._14accumulatedobjecttoconverter.v5.itinerary

import com.example.travelator._14accumulatedobjecttoconverter.v5.Id

data class Itinerary(
    val id: Id<Itinerary>,
    val route: Route,
    val accommodations: List<Accommodation> = emptyList(),
) {
    fun addCostsTo(calculator: CostSummaryCalculator) {
//        route.addCostsTo(calculator)
        accommodations.addCostsTo(calculator)
    }

}

// 가변 상태에 비용을 누적하기 위해 부수효과를 활용하는 코드
private fun Iterable<Accommodation>.addCostsTo(calculator: CostSummaryCalculator) {
    forEach { it.addCostsTo(calculator) }
}