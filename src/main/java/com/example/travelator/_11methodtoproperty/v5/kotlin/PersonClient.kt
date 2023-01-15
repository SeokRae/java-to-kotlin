package com.example.travelator._11methodtoproperty.v5.kotlin

import com.example.travelator._11methodtoproperty.v4.java.PersonWithPublicFields

object PersonClient {
    fun findAndAccessor(person: PersonWithPublicFields) =
        person.givenName + " " + person.fullName
}