package com.detsimov.leakchecker.data.network.request

import kotlinx.serialization.Serializable

@Serializable
data class LeakCheckRequest(val emails: List<String>)