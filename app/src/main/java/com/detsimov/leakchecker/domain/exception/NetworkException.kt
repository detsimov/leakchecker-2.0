package com.detsimov.leakchecker.domain.exception

import com.github.michaelbull.result.Err
import com.github.michaelbull.result.Ok
import com.github.michaelbull.result.Result
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract

sealed class NetworkException : Throwable() {
    object NoInternet : NetworkException()
    object NoResponse : NetworkException()
    object BadRequest : NetworkException()
    class NoHandled(val code: Int, val description: String) : NetworkException()
    class Unknown(val exception: Throwable) : NetworkException()
}

@OptIn(ExperimentalContracts::class)
inline infix fun <T, V> T.runCatchingNetwork(block: T.() -> V): Result<V, NetworkException> {
    contract {
        callsInPlace(block, InvocationKind.EXACTLY_ONCE)
    }

    return try {
        Ok(block())
    } catch (e: NetworkException) {
        Err(e)
    }
}
