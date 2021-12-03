package com.detsimov.leakchecker.data.storage

import androidx.room.Database
import androidx.room.RoomDatabase
import com.detsimov.leakchecker.data.storage.dao.BreachDao
import com.detsimov.leakchecker.data.storage.dao.TrackerDao
import com.detsimov.leakchecker.data.storage.entity.BreachEntity
import com.detsimov.leakchecker.data.storage.entity.TrackerEntity

@Database(entities = [TrackerEntity::class, BreachEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {

    abstract fun trackerDao(): TrackerDao

    abstract fun breachDao(): BreachDao
}