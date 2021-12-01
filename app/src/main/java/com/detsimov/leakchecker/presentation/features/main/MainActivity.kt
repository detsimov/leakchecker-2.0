package com.detsimov.leakchecker.presentation.features.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.detsimov.leakchecker.presentation.base.navigation.screen
import com.detsimov.leakchecker.presentation.features.main.api.MainScreenApi
import com.detsimov.leakchecker.presentation.features.navigation.MainNavigation
import com.detsimov.leakchecker.presentation.features.navigation.NavigationItem
import com.detsimov.leakchecker.presentation.features.navigation.graphs.bottomNavigationGraph
import com.detsimov.leakchecker.presentation.ui.theme.LeakCheckerTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LeakCheckerTheme {
                val navController = MainNavigation.init()
                NavHost(navController, startDestination = MainScreenApi.route()) {
                    screen(MainScreenApi)
                }
            }
        }
    }
}
