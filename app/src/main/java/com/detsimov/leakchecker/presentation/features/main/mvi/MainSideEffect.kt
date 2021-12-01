package com.detsimov.leakchecker.presentation.features.main.mvi

import com.detsimov.leakchecker.presentation.features.navigation.NavigationItem

sealed class MainSideEffect {

    class NavigateToItem(val item: NavigationItem) : MainSideEffect()
}