package com.detsimov.leakchecker.presentation.features.home

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import com.detsimov.leakchecker.presentation.features.home.mvi.HomeViewModel
import com.detsimov.leakchecker.presentation.features.home.ui.HomeContent
import org.koin.androidx.compose.getViewModel

@Composable
fun HomeScreen() {
    with(getViewModel<HomeViewModel>()) {
        val state by container.stateFlow.collectAsState()
        HomeContent(state)
    }
}