package com.detsimov.leakchecker.domain.di

import com.detsimov.leakchecker.domain.interactors.BreachInteractorImpl
import com.detsimov.leakchecker.domain.interactors.TrackerInteractorImpl
import com.detsimov.leakchecker.domain.interactors.i.BreachInteractor
import com.detsimov.leakchecker.domain.interactors.i.TrackerInteractor
import org.koin.dsl.module

val domainModule = module {
    /* Interactors */
    single<TrackerInteractor> { TrackerInteractorImpl(get()) }
    single<BreachInteractor> { BreachInteractorImpl(get(), get()) }
}