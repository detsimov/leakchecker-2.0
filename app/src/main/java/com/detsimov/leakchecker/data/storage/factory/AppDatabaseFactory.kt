package com.detsimov.leakchecker.data.storage.factory

import android.content.Context
import androidx.room.Room
import com.detsimov.leakchecker.data.storage.AppDatabase

class AppDatabaseFactory(private val applicationContext: Context) {

    fun create(): AppDatabase {
        return Room.databaseBuilder(applicationContext, AppDatabase::class.java, DATABASE_NAME)
            .build()
    }

    companion object {

        private const val DATABASE_NAME = "LeakCheckerDatabase"
    }
}