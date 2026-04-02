package com.alqiran.portfoliomain.ui.mapper

import com.alqiran.portfoliomain.data.datasourses.remote.model.ContactMessage
import com.alqiran.portfoliomain.ui.model.ContactMessageUiModel


fun List<ContactMessage>.toContactMessageDataUi(): List<ContactMessageUiModel> {
    return this.map { item ->
        ContactMessageUiModel(
            date = item.date,
            email = item.email,
            message = item.message
        )
    }
}