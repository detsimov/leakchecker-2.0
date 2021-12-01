package com.detsimov.leakchecker.presentation.features.notifications.api

import androidx.compose.ui.Modifier
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.detsimov.leakchecker.presentation.base.navigation.ScreenApi
import com.detsimov.leakchecker.presentation.features.notifications.NotificationsContent

object NotificationsScreenApi : ScreenApi {

    private const val baseRoute = "notifications"

    fun route() = baseRoute

    override fun attach(navGraphBuilder: NavGraphBuilder, modifier: Modifier) {
        navGraphBuilder.composable(baseRoute) { NotificationsContent() }
    }
}