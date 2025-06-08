package com.alqiran.portfoliomain.ui.mapper

import com.alqiran.portfoliomain.data.datasourses.remote.model.ContactMessage
import com.alqiran.portfoliomain.ui.model.ContactMessageUiModel

fun ContactMessageUiModel.toContactMessage(): ContactMessage {
    return ContactMessage(
        date = this.date,
        email = this.email,
        message = this.message
    )
}