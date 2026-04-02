package com.alqiran.portfoliomain.data.mapper

import com.alqiran.portfoliomain.data.datasourses.remote.model.Experience
import com.alqiran.portfoliomain.ui.model.ExperienceUiModel

fun ExperienceUiModel.toExperience(): Experience {
    return Experience(
        id = this.id,
        experienceTitle = this.experienceTitle,
        company = this.company,
        date = this.date,
        description = this.description
    )

}