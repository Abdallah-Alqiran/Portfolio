package com.alqiran.portfoliomain.ui.model

import kotlinx.serialization.Serializable

@Serializable
data class ContactAndAccountsUiModel (
    var id: Int = 0,
    var webName: String = "",
    var url: String = ""
)