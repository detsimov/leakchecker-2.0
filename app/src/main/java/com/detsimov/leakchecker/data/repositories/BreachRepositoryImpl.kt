package com.detsimov.leakchecker.data.repositories

import com.detsimov.leakchecker.data.storage.AppDatabase
import com.detsimov.leakchecker.domain.models.BreachesInfoModel
import com.detsimov.leakchecker.domain.repositories.BreachRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.combine

class BreachRepositoryImpl(appDatabase: AppDatabase) : BreachRepository {

    private val breachDao = appDatabase.breachDao()

    override val breachesInfoFlow: Flow<BreachesInfoModel> = combine(
        breachDao.fetchCount(true),
        breachDao.fetchCount(false)
    ) { isSeenCount, isNotSeenCount ->
        BreachesInfoModel(isNotSeenCount, isNotSeenCount + isSeenCount)
    }
}