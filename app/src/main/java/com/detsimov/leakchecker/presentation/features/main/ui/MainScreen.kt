package com.detsimov.leakchecker.presentation.features.main

import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.currentBackStackEntryAsState
import com.detsimov.leakchecker.presentation.features.main.ui.NavigationItem
import com.detsimov.leakchecker.presentation.ui.theme.LeakCheckerTheme

@Preview
@Composable
fun MainScreen_Preview() {
    LeakCheckerTheme {
        MainScreen()
    }
}

@Composable
fun MainScreen(navController: NavController) = Scaffold(
    bottomBar = {
        val items = remember { NavigationItem.values() }
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentDestination = navBackStackEntry?.destination
        BottomNavigation {
            items.forEach { item ->
                BottomNavigationItem(
                    selected = currentDestination?.hierarchy?.any { it.route == item.key } == true,
                    onClick = {
                        navController.navigate(item.key) {
                            popUpTo(navController.graph.findStartDestination().id) {
                                saveState = true
                            }
                            launchSingleTop = true
                            restoreState = true
                        }
                    },
                    icon = {

                    }
                )
            }
        }
    }
) {}