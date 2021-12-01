package com.detsimov.leakchecker.presentation.base.mvi

import androidx.lifecycle.ViewModel
import org.orbitmvi.orbit.Container
import org.orbitmvi.orbit.ContainerHost

abstract class MviViewModel<STATE : Any, SIDE_EFFECT : Any> : ViewModel(), ContainerHost<STATE, SIDE_EFFECT> {

    abstract override val container: Container<STATE, SIDE_EFFECT>
}