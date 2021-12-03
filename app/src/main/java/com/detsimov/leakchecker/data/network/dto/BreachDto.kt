package com.detsimov.leakchecker.data.network.dto

import com.detsimov.leakchecker.domain.models.BreachModel
import kotlinx.serialization.Serializable

class BreachDto {

    @Serializable
    data class Read(
        val email: String,
        val site: String,
        val description: String,
        val date: String
    ) {
        companion object {

            fun Read.toModel() = BreachModel(email, site, description, date)
        }
    }
}