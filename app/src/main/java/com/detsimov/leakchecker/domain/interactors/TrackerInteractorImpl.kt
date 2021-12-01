package com.detsimov.leakchecker.domain.interactors

import com.detsimov.leakchecker.domain.interactors.i.TrackerInteractor
import com.detsimov.leakchecker.domain.models.BreachesInfoModel
import com.detsimov.leakchecker.domain.models.TrackerStatusModel
import com.detsimov.leakchecker.domain.repositories.TrackerRepository
import kotlinx.coroutines.flow.Flow

class TrackerInteractorImpl(
    private val trackerRepository: TrackerRepository
) : TrackerInteractor {

    override val statusesFlow: Flow<List<TrackerStatusModel>>
        get() = trackerRepository.statusesFlow

    override val breachesInfoFlow: Flow<BreachesInfoModel>
        get() = trackerRepository.breachesInfoFlow
}