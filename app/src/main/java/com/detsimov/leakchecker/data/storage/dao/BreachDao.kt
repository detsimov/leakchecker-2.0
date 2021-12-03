package com.detsimov.leakchecker.data.storage.dao

import androidx.room.Dao
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface BreachDao {

    @Query("SELECT COUNT(id) from Breaches WHERE isSeen = :isSeen")
    fun fetchCount(isSeen: Boolean): Flow<Int>
}