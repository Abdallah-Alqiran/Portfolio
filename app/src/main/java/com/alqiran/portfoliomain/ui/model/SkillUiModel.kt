package com.alqiran.portfoliomain.ui.model

import kotlinx.serialization.Serializable

@Serializable
data class SkillUiModel(
    val id: Int = 0,
    val skillName: String = ""
)
