package com.detsimov.leakchecker.presentation.features.main

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.navigation.NavGraph.Companion.findStartDestination
import com.detsimov.leakchecker.presentation.features.main.mvi.MainSideEffect
import com.detsimov.leakchecker.presentation.features.main.mvi.MainViewModel
import com.detsimov.leakchecker.presentation.features.main.ui.MainContent
import com.detsimov.leakchecker.presentation.features.navigation.BottomNavigation
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import org.koin.androidx.compose.getViewModel

@Composable
fun MainScreen() {
    val viewModel = getViewModel<MainViewModel>()
    val navController = BottomNavigation.init()
    MainContent(
        navController = navController,
        onNavigationItemClicked = { viewModel.clickNavigationItem(it) }
    )
    LaunchedEffect(viewModel) {
        launch {
            viewModel.container.sideEffectFlow.collect { sideEffect ->
                when (sideEffect) {
                    is MainSideEffect.NavigateToItem -> navController.navigate(sideEffect.item.baseRoute) {
                        popUpTo(navController.graph.findStartDestination().id) {
                            saveState = true
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                }
            }
        }
    }
}