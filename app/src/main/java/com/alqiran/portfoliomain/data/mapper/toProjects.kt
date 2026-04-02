package com.alqiran.portfoliomain.data.mapper

import com.alqiran.portfoliomain.data.datasourses.remote.model.Project
import com.alqiran.portfoliomain.ui.model.ProjectUiModel

fun List<ProjectUiModel>.toProjects(): List<Project> {
    return this.map { item ->
        Project(
        id = item.id,
        image = item.image,
        projectName = item.projectName,
        description = item.description,
        githubUrl = item.githubUrl,
        googlePlayUrl = item.googlePlayUrl,
        appleStoreUrl = item.appleStoreUrl,
        )
    }
}