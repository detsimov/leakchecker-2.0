package com.detsimov.leakchecker.data.di

import com.detsimov.leakchecker.data.repositories.TrackerRepositoryImpl
import com.detsimov.leakchecker.domain.repositories.TrackerRepository
import org.koin.dsl.module

val dataModule = module {

    single<TrackerRepository> { TrackerRepositoryImpl() }
}