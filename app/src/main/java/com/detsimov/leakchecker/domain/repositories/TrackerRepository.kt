package com.detsimov.leakchecker.domain.repositories

import com.detsimov.leakchecker.domain.models.BreachesInfoModel
import com.detsimov.leakchecker.domain.models.TrackerStatusModel
import kotlinx.coroutines.flow.Flow

interface TrackerRepository {

    val statusesFlow: Flow<List<TrackerStatusModel>>

    suspend fun add(data: String)
}