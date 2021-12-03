package com.detsimov.leakchecker.data.network.factory

import io.ktor.client.*
import io.ktor.client.engine.android.*
import io.ktor.client.features.*
import io.ktor.client.features.json.*
import io.ktor.client.features.json.serializer.*
import io.ktor.client.features.logging.*
import io.ktor.client.request.*
import io.ktor.http.*
import kotlinx.serialization.json.Json

class HttpClientFactory {

    private val json = Json {
        ignoreUnknownKeys = true
        isLenient = true
        prettyPrint = true
    }

    fun create() = HttpClient(Android) {
        HttpResponseValidator {
            handleResponseException(CallExceptionHandlerDefault)
        }
        install(JsonFeature) {
            serializer = KotlinxSerializer(json)
        }
        install(HttpTimeout) {
            requestTimeoutMillis = REQUEST_TIMEOUT_MILLIS
            connectTimeoutMillis = CONNECT_TIMEOUT_MILLIS
        }
        install(Logging) {
            logger = Logger.ANDROID
            level = LogLevel.ALL
        }
        install(UserAgent) {
            agent = USER_AGENT
        }
        defaultRequest {
            contentType(ContentType.Application.Json)
            host = HOST
            port = PORT
        }
    }

    companion object {

        private const val HOST = "etaapatia.ru"
        private const val PORT = 8080

        private const val USER_AGENT = "Ktor-Android"

        private const val REQUEST_TIMEOUT_MILLIS = 30_000L
        private const val CONNECT_TIMEOUT_MILLIS = 15_000L
    }
}