package com.detsimov.leakchecker.presentation.features.home.mvi

import com.detsimov.leakchecker.domain.interactors.i.BreachInteractor
import com.detsimov.leakchecker.domain.interactors.i.TrackerInteractor
import com.detsimov.leakchecker.presentation.base.mvi.MviViewModel
import com.detsimov.leakchecker.presentation.base.mvi.bootstrap
import kotlinx.coroutines.flow.collect
import org.orbitmvi.orbit.Container
import org.orbitmvi.orbit.syntax.simple.intent
import org.orbitmvi.orbit.syntax.simple.reduce
import org.orbitmvi.orbit.viewmodel.container

class HomeViewModel(
    private val trackerInteractor: TrackerInteractor,
    private val breachInteractor: BreachInteractor
) : MviViewModel<HomeState, Nothing>() {

    override val container: Container<HomeState, Nothing> = container(HomeState())

    init {
        trackersBootstrap()
        breachesInfoBootstrap()
    }

    fun addTracker(email: String) = intent {
        trackerInteractor.add(email)
        reduce { state.copy(isTrackerCreatorDialogShowing = false) }
    }

    fun openTrackerCreatorDialog() = intent {
        reduce { state.copy(isTrackerCreatorDialogShowing = true) }
    }

    fun closeTrackerCreatorDialog() = intent {
        reduce { state.copy(isTrackerCreatorDialogShowing = false) }
    }

    private fun trackersBootstrap() = bootstrap {
        trackerInteractor.statusesFlow.collect {
            reduce { state.copy(isTrackersLoading = false, trackers = it) }
        }
    }

    private fun breachesInfoBootstrap() = bootstrap {
        breachInteractor.breachesInfoFlow.collect {
            reduce { state.copy(breachesInfo = it) }
        }
    }
}