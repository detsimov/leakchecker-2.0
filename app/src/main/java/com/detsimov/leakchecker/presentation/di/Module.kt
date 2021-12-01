package com.detsimov.leakchecker.presentation.di

import com.detsimov.leakchecker.presentation.features.home.mvi.HomeViewModel
import com.detsimov.leakchecker.presentation.features.main.mvi.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val presentationModule = module {
    viewModel { MainViewModel() }
    viewModel { HomeViewModel(get()) }
}