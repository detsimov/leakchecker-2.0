package com.detsimov.leakchecker.presentation.features.main.mvi

import com.detsimov.leakchecker.presentation.base.mvi.EmptyState
import com.detsimov.leakchecker.presentation.base.mvi.MviViewModel
import com.detsimov.leakchecker.presentation.features.navigation.NavigationItem
import org.orbitmvi.orbit.Container
import org.orbitmvi.orbit.syntax.simple.intent
import org.orbitmvi.orbit.syntax.simple.postSideEffect
import org.orbitmvi.orbit.viewmodel.container

class MainViewModel : MviViewModel<EmptyState, MainSideEffect>() {

    override val container: Container<EmptyState, MainSideEffect> = container(EmptyState)

    fun clickNavigationItem(item: NavigationItem) = intent {
        postSideEffect(MainSideEffect.NavigateToItem(item))
    }
}