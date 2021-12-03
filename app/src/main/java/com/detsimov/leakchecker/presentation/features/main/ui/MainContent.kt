package com.detsimov.leakchecker.presentation.features.main.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.currentBackStackEntryAsState
import com.detsimov.leakchecker.presentation.features.navigation.NavigationItem
import com.detsimov.leakchecker.presentation.features.navigation.graphs.bottomNavigationGraph

@Composable
fun MainContent(
    navController: NavHostController,
    onNavigationItemClicked: (NavigationItem) -> Unit
) = Scaffold(
    content = { innerPadding ->
        Box(modifier = Modifier.padding(innerPadding)) {
            NavHost(navController, startDestination = NavigationItem.HOME.baseRoute) {
                bottomNavigationGraph()
            }
        }
    },
    bottomBar = {
        val items = remember { NavigationItem.values() }
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentDestination = navBackStackEntry?.destination
        BottomNavigation {
            items.forEach { item ->
                BottomNavigationItem(
                    selected = currentDestination?.hierarchy?.any { it.route == item.baseRoute } == true,
                    onClick = { onNavigationItemClicked(item) },
                    icon = { Icon(imageVector = item.icon, contentDescription = null) },
                    label = { Text(text = stringResource(id = item.titleRes)) }
                )
            }
        }
    }
)