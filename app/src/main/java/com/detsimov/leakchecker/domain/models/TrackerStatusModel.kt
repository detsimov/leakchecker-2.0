package com.detsimov.leakchecker.domain.models

data class TrackerStatusModel(
    val data: String,
    val dataType: TrackerDataType,
    val breachesCount: Int,
    val newBreachesCount: Int,
)