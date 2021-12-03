package com.detsimov.leakchecker.domain.repositories

import com.detsimov.leakchecker.domain.models.BreachesInfoModel
import kotlinx.coroutines.flow.Flow

interface BreachRepository {

    val breachesInfoFlow: Flow<BreachesInfoModel>
}