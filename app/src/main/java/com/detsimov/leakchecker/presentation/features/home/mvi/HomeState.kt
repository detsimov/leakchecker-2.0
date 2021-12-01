package com.detsimov.leakchecker.presentation.features.home.mvi

import com.detsimov.leakchecker.domain.models.BreachesInfoModel
import com.detsimov.leakchecker.domain.models.TrackerStatusModel

data class HomeState(
    val isBreachesInfoLoading: Boolean = true,
    val breachesInfo: BreachesInfoModel = BreachesInfoModel(0, 0),
    val isTrackersLoading: Boolean = true,
    val trackers: List<TrackerStatusModel> = emptyList()
)