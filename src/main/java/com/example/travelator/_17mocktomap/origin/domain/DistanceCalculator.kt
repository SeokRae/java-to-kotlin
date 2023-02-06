package com.example.travelator._17mocktomap.origin.domain

interface DistanceCalculator {
    fun distanceInMetersBetween(
        start: Location,
        end: Location
    ): Int

    fun travelTimeInSecondsBetween(
        start: Location,
        end: Location
    ): Int
}