package com.detsimov.leakchecker.domain.interactors

import com.detsimov.leakchecker.domain.interactors.i.TrackerInteractor
import com.detsimov.leakchecker.domain.models.BreachesInfoModel
import com.detsimov.leakchecker.domain.models.TrackerStatusModel
import com.detsimov.leakchecker.domain.repositories.TrackerRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext

class TrackerInteractorImpl(
    private val trackerRepository: TrackerRepository
) : TrackerInteractor {

    override val statusesFlow: Flow<List<TrackerStatusModel>>
        get() = trackerRepository.statusesFlow

    override suspend fun add(email: String) = withContext(Dispatchers.IO) {
        trackerRepository.add(email)
    }
}