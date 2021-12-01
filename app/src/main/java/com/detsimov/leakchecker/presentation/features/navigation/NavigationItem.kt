package com.detsimov.leakchecker.presentation.features.navigation

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.ui.graphics.vector.ImageVector
import com.detsimov.leakchecker.R

enum class NavigationItem(
    val baseRoute: String,
    val icon: ImageVector,
    @StringRes val titleRes: Int
) {
    HOME(
        "nav_home",
        Icons.Filled.Home,
        R.string.home_title
    ),
    SETTINGS(
        "nav_settings",
        Icons.Filled.Settings,
        R.string.settings_title
    )
}