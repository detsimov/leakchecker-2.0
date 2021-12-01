package com.detsimov.leakchecker.presentation.features.navigation.graphs

import androidx.navigation.NavGraphBuilder
import androidx.navigation.navigation
import com.detsimov.leakchecker.presentation.base.navigation.screen
import com.detsimov.leakchecker.presentation.features.navigation.NavigationItem
import com.detsimov.leakchecker.presentation.features.home.api.HomeScreenApi
import com.detsimov.leakchecker.presentation.features.notifications.api.NotificationsScreenApi
import com.detsimov.leakchecker.presentation.features.settings.api.SettingsScreenApi

fun NavGraphBuilder.bottomNavigationGraph() {
    navigation(startDestination = HomeScreenApi.route(), route = NavigationItem.HOME.baseRoute) {
        screen(HomeScreenApi)
    }
    navigation(startDestination = SettingsScreenApi.route(), route = NavigationItem.SETTINGS.baseRoute) {
        screen(SettingsScreenApi)
        screen(NotificationsScreenApi)
    }
}