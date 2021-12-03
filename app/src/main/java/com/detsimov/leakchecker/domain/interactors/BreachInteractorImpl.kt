package com.detsimov.leakchecker.domain.interactors

import com.detsimov.leakchecker.domain.exception.NetworkException
import com.detsimov.leakchecker.domain.interactors.i.BreachInteractor
import com.detsimov.leakchecker.domain.models.BreachModel
import com.detsimov.leakchecker.domain.models.BreachesInfoModel
import com.detsimov.leakchecker.domain.repositories.BreachRepository
import com.detsimov.leakchecker.domain.service.BreachService
import com.github.michaelbull.result.Result
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext

class BreachInteractorImpl(
    private val breachService: BreachService,
    private val breachRepository: BreachRepository
) : BreachInteractor {

    override val breachesInfoFlow: Flow<BreachesInfoModel>
        get() = breachRepository.breachesInfoFlow

    override suspend fun check(
        emails: List<String>
    ): Result<List<BreachModel>, NetworkException> = withContext(Dispatchers.IO) {
        breachService.check(emails)
    }
}