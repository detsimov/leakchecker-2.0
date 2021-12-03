package com.detsimov.leakchecker.data.storage.dao

import androidx.room.*
import com.detsimov.leakchecker.data.storage.entity.TrackerEntity
import com.detsimov.leakchecker.data.storage.entity.relationships.TrackerWithBreachesEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface TrackerDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun add(tracker: TrackerEntity)

    @Transaction
    @Query("SELECT * FROM Trackers")
    fun getTrackersWithBreaches(): Flow<List<TrackerWithBreachesEntity>>
}