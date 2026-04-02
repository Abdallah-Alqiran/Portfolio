package com.alqiran.portfoliomain.data.mapper

import com.alqiran.portfoliomain.data.datasourses.remote.model.Education
import com.alqiran.portfoliomain.ui.model.EducationUiModel

fun List<EducationUiModel>.toEducations(): List<Education> {
    return this.map { item ->
        Education(
        id = item.id,
        university = item.university,
        date = item.date,
        major = item.major
        )
    }
}