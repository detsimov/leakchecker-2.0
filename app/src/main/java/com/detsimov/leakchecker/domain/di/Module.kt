package com.detsimov.leakchecker.domain.di

import com.detsimov.leakchecker.domain.interactors.TrackerInteractorImpl
import com.detsimov.leakchecker.domain.interactors.i.TrackerInteractor
import org.koin.dsl.module

val domainModule = module {
    single<TrackerInteractor> { TrackerInteractorImpl(get()) }
}