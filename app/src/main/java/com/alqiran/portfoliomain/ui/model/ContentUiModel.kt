package com.alqiran.portfoliomain.ui.model

import kotlinx.serialization.Serializable

@Serializable
data class ContentUiModel (
    val id: Int = 0,
    val contentDescription: String = "",
    val contentUrl: String = ""
)
