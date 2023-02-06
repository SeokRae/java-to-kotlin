package com.example.travelator._19errors.origin.handlers

import com.example.travelator._19errors.origin.*
import com.example.travelator._19errors.origin.http.Request
import com.example.travelator._19errors.origin.http.Response
import com.fasterxml.jackson.core.JsonProcessingException
import com.fasterxml.jackson.databind.ObjectMapper
import java.net.HttpURLConnection.*

class CustomerRegistrationHandler(
    private val registration: IRegisterCustomers
) {
    private val objectMapper = ObjectMapper()

    fun handle(request: Request): Response =
        try {
            val data = objectMapper.readValue(
                request.body,
                RegistrationData::class.java
            )
            registration.register(data)
                .map { value ->
                    Response(
                        HTTP_CREATED,
                        objectMapper.writeValueAsString(value)
                    )
                }
                .recover { reason -> reason.toResponse() }
        } catch (x: JsonProcessingException) {
            Response(HTTP_BAD_REQUEST)
        } catch (x: Exception) {
            Response(HTTP_INTERNAL_ERROR)
        }
}

private fun RegistrationProblem.toResponse() = when (this) {
    is Duplicate -> Response(HTTP_CONFLICT)
    is Excluded -> Response(HTTP_FORBIDDEN)
    is DatabaseProblem -> Response(HTTP_INTERNAL_ERROR) // <1>
}