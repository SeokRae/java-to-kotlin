package com.example.travelator._19errors.origin.handlers

import com.example.travelator._19errors.origin.Customer
import com.example.travelator._19errors.origin.IRegisterCustomers
import dev.forkhandles.result4k.Failure
import dev.forkhandles.result4k.Success
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.mockito.Mockito
import java.net.HttpURLConnection

class CustomerRegistrationHandlerTests {
    val registration: IRegisterCustomers = Mockito.mock(IRegisterCustomers::class.java)
    val handler = CustomerRegistrationHandler(registration)
    val fredBody = toJson(
        "{ 'name' : 'fred', 'email' : 'fred@bedrock.com' }"
    )
    val fredData = RegistrationData("fred", "fred@bedrock.com")
    @Test
    fun returns_Created_with_body_on_success() {
        Mockito.`when`(registration.register(fredData))
            .thenReturn(
                Success(
                    Customer("0", fredData.name, fredData.email)
                )
            )
        val expectedBody = toJson(
            "{'id':'0','name':'fred','email':'fred@bedrock.com'}"
        )
        assertEquals(
            Response(HttpURLConnection.HTTP_CREATED, expectedBody),
            handler.handle(Request(fredBody))
        )
    }

    @Test
    fun returns_Conflict_for_duplicate() {
        Mockito.`when`(registration.register(fredData))
            .thenReturn(
                Failure(
                    Duplicate("deliberate")
                )
            )
        assertEquals(
            Response(HttpURLConnection.HTTP_CONFLICT),
            handler.handle(Request(fredBody))
        )
    }

    @Test
    fun returns_Forbidden_for_excluded() {
        Mockito.`when`(registration.register(fredData))
            .thenReturn(
                Failure(
                    Excluded.INSTANCE
                )
            )
        assertEquals(
            Response(HttpURLConnection.HTTP_FORBIDDEN),
            handler.handle(Request(fredBody))
        )
    }

    @Test
    fun returns_InternalError_for_database() {
        Mockito.`when`(registration.register(fredData))
            .thenReturn(
                Failure(
                    DatabaseProblem("deliberate")
                )
            )
        assertEquals(
            Response(HttpURLConnection.HTTP_INTERNAL_ERROR),
            handler.handle(Request(fredBody))
        )
    }

    @Test
    fun returns_BadRequest_for_bad_json() {
        assertEquals(
            Response(HttpURLConnection.HTTP_BAD_REQUEST),
            handler.handle(Request("bad json"))
        )
    }

    @Test
    fun returns_InternalError_for_other_exceptions() {
        Mockito.`when`(registration.register(fredData))
            .thenThrow(
                RuntimeException("deliberate")
            )
        assertEquals(
            Response(HttpURLConnection.HTTP_INTERNAL_ERROR),
            handler.handle(Request(fredBody))
        )
    }

    private fun toJson(jsonIsh: String): String {
        return jsonIsh.replace('\'', '"')
    }
}