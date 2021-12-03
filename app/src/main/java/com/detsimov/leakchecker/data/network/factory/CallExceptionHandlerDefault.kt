package com.detsimov.leakchecker.data.network.factory

import com.detsimov.leakchecker.domain.exception.NetworkException
import io.ktor.client.features.*
import io.ktor.http.*
import java.net.ConnectException
import java.net.UnknownHostException

val CallExceptionHandlerDefault: suspend (Throwable) -> Unit = { exception ->
    throw when (exception) {
        is UnknownHostException -> {
            NetworkException.NoInternet
        }
        is ConnectException -> {
            NetworkException.NoResponse
        }
        is ClientRequestException -> {
            when (val status = exception.response.status) {
                HttpStatusCode.BadRequest -> NetworkException.BadRequest
                else -> NetworkException.NoHandled(status.value, status.description)
            }
        }
        else -> {
            NetworkException.Unknown(exception)
        }
    }
}
