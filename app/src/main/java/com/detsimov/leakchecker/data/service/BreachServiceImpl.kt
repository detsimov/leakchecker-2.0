package com.detsimov.leakchecker.data.service

import com.detsimov.leakchecker.data.network.dto.BreachDto.Read.Companion.toModel
import com.detsimov.leakchecker.data.network.request.LeakCheckRequest
import com.detsimov.leakchecker.data.network.response.LeakCheckResponse
import com.detsimov.leakchecker.domain.exception.NetworkException
import com.detsimov.leakchecker.domain.exception.runCatchingNetwork
import com.detsimov.leakchecker.domain.models.BreachModel
import com.detsimov.leakchecker.domain.service.BreachService
import com.github.michaelbull.result.Result
import io.ktor.client.*
import io.ktor.client.request.*

class BreachServiceImpl(private val httpClient: HttpClient) : BreachService {

    override suspend fun check(emails: List<String>): Result<List<BreachModel>, NetworkException> {
        return runCatchingNetwork {
            val response = httpClient.post<LeakCheckResponse>(LEAK_CHECK_ENDPOINT) {
                body = LeakCheckRequest(emails)
            }
            response.leaks.map { it.toModel() }
        }
    }

    companion object {

        private const val LEAK_CHECK_ENDPOINT = "/leaks/check"
    }
}