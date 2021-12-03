package com.detsimov.leakchecker.domain.interactors.i

import com.detsimov.leakchecker.domain.models.BreachesInfoModel
import com.detsimov.leakchecker.domain.models.TrackerStatusModel
import kotlinx.coroutines.flow.Flow

interface TrackerInteractor {

    val statusesFlow: Flow<List<TrackerStatusModel>>

    suspend fun add(email: String)
}