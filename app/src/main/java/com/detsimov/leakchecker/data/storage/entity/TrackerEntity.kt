package com.detsimov.leakchecker.data.storage.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Trackers")
data class TrackerEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val email: String,
    val lastCheckTime: Long = 0,
)