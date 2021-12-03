package com.detsimov.leakchecker.data.network.response

import com.detsimov.leakchecker.data.network.dto.BreachDto
import kotlinx.serialization.Serializable

@Serializable
data class LeakCheckResponse(val leaks: List<BreachDto.Read>)