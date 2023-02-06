package com.example.travelator._18opentosealed.origin.calendar

import com.example.travelator._18opentosealed.origin.Id
import com.example.travelator._18opentosealed.origin.Location
import java.net.URI
import java.time.ZonedDateTime

data class Calendar(
    val id: Id<Calendar>,
    val events: Collection<CalendarEvent>
) {
    companion object
}

data class CalendarEvent(
    val id: Id<CalendarEvent> = Id.mint(),
    val start: ZonedDateTime,
    val end: ZonedDateTime? = null,
    val description: String,
    val icon: URI? = null,
    val location: Location? = null,
    val alarms: List<Alarm> = emptyList()
)

data class Alarm(
    val time: ZonedDateTime,
    val description: String? = null
)