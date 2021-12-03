package com.detsimov.leakchecker.data.di

import com.detsimov.leakchecker.data.network.factory.HttpClientFactory
import com.detsimov.leakchecker.data.repositories.BreachRepositoryImpl
import com.detsimov.leakchecker.data.repositories.TrackerRepositoryImpl
import com.detsimov.leakchecker.data.service.BreachServiceImpl
import com.detsimov.leakchecker.data.storage.AppDatabase
import com.detsimov.leakchecker.data.storage.factory.AppDatabaseFactory
import com.detsimov.leakchecker.domain.repositories.BreachRepository
import com.detsimov.leakchecker.domain.repositories.TrackerRepository
import com.detsimov.leakchecker.domain.service.BreachService
import org.koin.dsl.module

val dataModule = module {
    /* Network */
    factory { HttpClientFactory() }
    single(createdAtStart = true) { get<HttpClientFactory>().create() }

    /* Storage */
    factory { AppDatabaseFactory(get()) }
    single(createdAtStart = true) { get<AppDatabaseFactory>().create() }

    /* Repositories */
    single<TrackerRepository> { TrackerRepositoryImpl(get()) }
    single<BreachRepository> { BreachRepositoryImpl(get()) }

    /* Services */
    single<BreachService> { BreachServiceImpl(get()) }
}