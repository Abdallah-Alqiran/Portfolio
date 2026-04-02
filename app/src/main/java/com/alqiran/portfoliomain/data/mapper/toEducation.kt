package com.alqiran.portfoliomain.data.mapper

import com.alqiran.portfoliomain.data.datasourses.remote.model.Education
import com.alqiran.portfoliomain.ui.model.EducationUiModel

fun EducationUiModel.toEducation(): Education {
    return Education(
        id = this.id,
        university = this.university,
        date = this.date,
        major = this.major
    )
    
}