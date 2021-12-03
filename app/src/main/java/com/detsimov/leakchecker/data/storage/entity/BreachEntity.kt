package com.detsimov.leakchecker.data.storage.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Breaches")
data class BreachEntity(
    @PrimaryKey val id: Int,
    val trackerId: Int,
    val email: String,
    val site: String,
    val description: String,
    val date: String,
    val checkTime: Long,
    val isSeen: Boolean,
)
