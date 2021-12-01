package com.detsimov.leakchecker.presentation.features.notifications

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
import com.detsimov.leakchecker.presentation.ui.theme.LeakCheckerTheme

@Preview
@Composable
fun NotificationsContent_Preview() {
    LeakCheckerTheme { NotificationsContent() }
}

@Composable
fun NotificationsContent() {
    val navController = BottomNavigation.controller
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Column {
            Text(text = "Notifications")
            Button(onClick = { navController.popBackStack() }) {
                Text(text = "Back")
            }
        }
    }
}