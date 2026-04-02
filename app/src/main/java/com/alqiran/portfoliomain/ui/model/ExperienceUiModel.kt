package com.alqiran.portfoliomain.ui.model

import kotlinx.serialization.Serializable

@Serializable
data class ExperienceUiModel(
    val id: Int = 0,
    val experienceTitle: String = "",
    val company: String = "",
    val date: String = "",
    val description: String = ""
)
