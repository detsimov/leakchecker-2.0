package com.detsimov.leakchecker.domain.models

data class TrackerStatusModel(
    val id: Int,
    val data: String,
    val dataType: TrackerDataType,
    val breachesCount: Int,
    val newBreachesCount: Int,
)