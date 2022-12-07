package com.example.travelator.collections.version8

import com.example.travelator.collections.version7.Other.SOME_COMPLICATED_RESULT

object Suffering {
    @JvmStatic
    fun sufferScoreFor(route: List<Journey>): Int =
        sufferScore(
            route.longestJourneys(limit = 3),
            Routes.getDepartsFrom(route)
        )

    // longestJourneys가 파라미터를 변경하지 않았기 때문에 함수를 단일식 함수로 변경
    @JvmStatic
    fun List<Journey>.longestJourneys(limit: Int) =
        sortedByDescending { it.duration }.take(limit)

    /**
     * 데이터를 제 자리에서 변경하는 코드 -> 새로운 값을 계산하고 참조가 이 새 값을 가리키게 하는 코드로 변경
     */
    fun routesToShowFor(itineraryId: String?): List<List<Journey>> =
        bearable(Other.routesFor(itineraryId))

    private fun bearable(routes: List<List<Journey>>): List<List<Journey>> =
        routes.filter { sufferScoreFor(it) <= 10 }

    private fun sufferScore(
        longestJourneys: List<Journey>,
        start: Location,
    ): Int =
        SOME_COMPLICATED_RESULT()
}