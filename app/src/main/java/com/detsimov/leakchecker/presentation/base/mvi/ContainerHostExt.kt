package com.detsimov.leakchecker.presentation.base.mvi

import kotlinx.coroutines.runBlocking
import org.orbitmvi.orbit.syntax.OrbitDsl
import org.orbitmvi.orbit.syntax.simple.SimpleSyntax

@OrbitDsl
public fun <STATE : Any, SIDE_EFFECT : Any> MviViewModel<STATE, SIDE_EFFECT>.bootstrap(
    transformer: suspend SimpleSyntax<STATE, SIDE_EFFECT>.() -> Unit
) {
    runBlocking {
        container.orbit {
            SimpleSyntax(this).transformer()
        }
    }
}