package com.detsimov.leakchecker.domain.interactors.i

import com.detsimov.leakchecker.domain.exception.NetworkException
import com.detsimov.leakchecker.domain.models.BreachModel
import com.detsimov.leakchecker.domain.models.BreachesInfoModel
import com.detsimov.leakchecker.domain.models.TrackerStatusModel
import com.github.michaelbull.result.Result
import kotlinx.coroutines.flow.Flow

interface BreachInteractor {

    val breachesInfoFlow: Flow<BreachesInfoModel>

    suspend fun check(emails: List<String>): Result<List<BreachModel>, NetworkException>
}