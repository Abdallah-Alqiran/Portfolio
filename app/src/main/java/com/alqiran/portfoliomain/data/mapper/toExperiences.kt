package com.alqiran.portfoliomain.data.mapper

import com.alqiran.portfoliomain.data.datasourses.remote.model.Education
import com.alqiran.portfoliomain.data.datasourses.remote.model.Experience
import com.alqiran.portfoliomain.ui.model.EducationUiModel
import com.alqiran.portfoliomain.ui.model.ExperienceUiModel

fun List<ExperienceUiModel>.toExperiences(): List<Experience> {
    return this.map { item ->
        Experience(
            id = item.id,
            experienceTitle = item.experienceTitle,
            company = item.company,
            date = item.date,
            description = item.description
        )
    }
}