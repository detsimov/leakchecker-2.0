package com.detsimov.leakchecker.data.repositories

import com.detsimov.leakchecker.common.mapList
import com.detsimov.leakchecker.data.storage.AppDatabase
import com.detsimov.leakchecker.data.storage.entity.TrackerEntity
import com.detsimov.leakchecker.data.storage.entity.relationships.TrackerWithBreachesEntity.Companion.toTrackerStatusModel
import com.detsimov.leakchecker.domain.models.TrackerStatusModel
import com.detsimov.leakchecker.domain.repositories.TrackerRepository
import kotlinx.coroutines.flow.Flow

class TrackerRepositoryImpl(appDatabase: AppDatabase) : TrackerRepository {

    private val trackerDao = appDatabase.trackerDao()

    override val statusesFlow: Flow<List<TrackerStatusModel>> = trackerDao.getTrackersWithBreaches()
        .mapList { it.toTrackerStatusModel() }

    override suspend fun add(data: String) {
        trackerDao.add(TrackerEntity(email = data))
    }
}