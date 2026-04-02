package com.alqiran.portfoliomain.ui.model

import kotlinx.serialization.Serializable

@Serializable
data class EducationUiModel(
    val id : Int = 0,
    val university: String = "",
    val date: String = "",
    val major: String = ""
)
