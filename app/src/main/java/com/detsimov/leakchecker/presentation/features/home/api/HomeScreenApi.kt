package com.detsimov.leakchecker.presentation.features.home.api

import androidx.compose.ui.Modifier
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.detsimov.leakchecker.presentation.base.navigation.ScreenApi
import com.detsimov.leakchecker.presentation.features.home.HomeScreen

object HomeScreenApi : ScreenApi {

    private const val baseRoute = "home"

    fun route() = baseRoute

    override fun attach(navGraphBuilder: NavGraphBuilder, modifier: Modifier) {
        navGraphBuilder.composable(baseRoute) { HomeScreen() }
    }
}