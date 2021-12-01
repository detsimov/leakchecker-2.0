package com.detsimov.leakchecker.presentation.features.settings.api

import androidx.compose.ui.Modifier
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.detsimov.leakchecker.presentation.base.navigation.ScreenApi
import com.detsimov.leakchecker.presentation.features.settings.SettingsContent

object SettingsScreenApi : ScreenApi {

    private const val baseRoute = "settings"

    fun route() = baseRoute

    override fun attach(
        navGraphBuilder: NavGraphBuilder,
        modifier: Modifier
    ) {
        navGraphBuilder.composable(baseRoute) { SettingsContent() }
    }
}