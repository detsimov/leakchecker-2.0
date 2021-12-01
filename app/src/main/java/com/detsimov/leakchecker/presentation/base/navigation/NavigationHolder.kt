package com.detsimov.leakchecker.presentation.base.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController

abstract class NavigationHolder {

    lateinit var controller: NavController
        private set

    @Composable
    fun init(): NavHostController {
        require(!this::controller.isInitialized)
        return rememberNavController().also { controller = it }
    }
}