package com.detsimov.leakchecker.presentation.base.navigation

import androidx.compose.ui.Modifier
import androidx.navigation.NavGraphBuilder

fun NavGraphBuilder.screen(api: ScreenApi, modifier: Modifier = Modifier) {
    api.attach(this, modifier)
}