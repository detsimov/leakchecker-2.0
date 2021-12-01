package com.detsimov.leakchecker.presentation.features.main.api

import androidx.compose.ui.Modifier
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.detsimov.leakchecker.presentation.base.navigation.ScreenApi
import com.detsimov.leakchecker.presentation.features.main.MainScreen

object MainScreenApi : ScreenApi {

    private const val baseRoute = "main"

    fun route() = baseRoute

    override fun attach(
        navGraphBuilder: NavGraphBuilder,
        modifier: Modifier
    ) {
        navGraphBuilder.composable(baseRoute) { MainScreen() }
    }
}
