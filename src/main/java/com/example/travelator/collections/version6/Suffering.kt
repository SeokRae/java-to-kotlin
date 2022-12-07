package com.example.travelator.collections.version6

import com.example.travelator.collections.version4.Collections

object Suffering {
    @JvmStatic
    fun sufferScoreFor(
        // 경로를 표현
        route: List<Journey>,
    ): Int {
        return sufferScore(
            longestJourneysIn(route, 3),
            getDepartsFrom(route)
        )
    }

    @JvmStatic
    fun longestJourneysIn(
        journeys: List<Journey>,
        limit: Int,
    ): List<Journey> {
        // 경로를 길이 순으로 정렬
        val actualLimit = Math.min(journeys.size, limit)
        return Collections.sorted(
            journeys,
            Comparator.comparing { obj: Journey -> obj.duration }
                .reversed()
        ).subList(0, actualLimit)
    }

    private fun getDepartsFrom(route: List<Journey>): Location {
        return route[0].departsFrom
    }

    /**
     * 데이터를 제 자리에서 변경하는 코드 -> 새로운 값을 계산하고 참조가 이 새 값을 가리키게 하는 코드로 변경
     */
    fun routesToShowFor(itineraryId: String): List<List<Journey>> {
        return bearable(routesFor(itineraryId))
    }

    /**
     *
     */
    private fun bearable(
        routes: List<List<Journey>>,
    ): List<List<Journey>> {
        return routes.stream()
            .filter { route: List<Journey> -> sufferScoreFor(route) <= 10 }
            .toList()
    }

    private fun routesFor(itineraryId: String): List<List<Journey>> {
        return listOf()
    }

    private fun sufferScore(
        longestJourneys: List<Journey>,
        start: Location,
    ): Int {
        return SOME_COMPLICATED_RESULT()
    }

    private fun SOME_COMPLICATED_RESULT(): Int {
        return 0
    }
}