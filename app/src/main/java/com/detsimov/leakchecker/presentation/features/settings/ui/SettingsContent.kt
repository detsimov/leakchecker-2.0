package com.detsimov.leakchecker.presentation.features.settings

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.detsimov.leakchecker.presentation.features.navigation.BottomNavigation
import com.detsimov.leakchecker.presentation.features.notifications.api.NotificationsScreenApi
import com.detsimov.leakchecker.presentation.ui.theme.LeakCheckerTheme

@Preview
@Composable
fun SettingsContent_Preview() {
    LeakCheckerTheme { SettingsContent() }
}

@Composable
fun SettingsContent() {
    val navController = BottomNavigation.controller
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Column {
            Text(text = "Settings")
            Button(onClick = { navController.navigate(NotificationsScreenApi.route()) }) {
                Text(text = "Navigate")
            }
        }
    }
}