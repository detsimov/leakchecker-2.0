package com.detsimov.leakchecker.presentation.base.navigation

import androidx.compose.ui.Modifier
import androidx.navigation.NavGraphBuilder

interface ScreenApi {

    fun attach(
        navGraphBuilder: NavGraphBuilder,
        modifier: Modifier
    )
}