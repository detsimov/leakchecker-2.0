package com.detsimov.leakchecker.domain.service

import com.detsimov.leakchecker.domain.exception.NetworkException
import com.detsimov.leakchecker.domain.models.BreachModel
import com.github.michaelbull.result.Result

interface BreachService {

    suspend fun check(emails: List<String>): Result<List<BreachModel>, NetworkException>
}