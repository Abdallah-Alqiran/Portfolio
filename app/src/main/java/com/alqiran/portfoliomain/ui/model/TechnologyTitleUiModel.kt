package com.alqiran.portfoliomain.ui.model

import kotlinx.serialization.Serializable

@Serializable
data class TechnologyTitleUiModel (
    val id: Int = 0,
    val technologyTitle: String = "",
    val technologies: List<TechnologyUiModel> = emptyList()
)