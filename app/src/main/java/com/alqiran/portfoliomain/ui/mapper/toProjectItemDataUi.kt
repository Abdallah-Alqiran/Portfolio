package com.alqiran.portfoliomain.ui.mapper

import com.alqiran.portfoliomain.data.datasourses.remote.model.Project
import com.alqiran.portfoliomain.ui.model.ProjectUiModel

fun Project.toProjectItemDataUi(): ProjectUiModel {
    return ProjectUiModel(
        id = this.id,
        image = this.image,
        projectName = this.projectName,
        description = this.description,
        githubUrl = this.githubUrl,
        googlePlayUrl = this.googlePlayUrl,
        appleStoreUrl = this.appleStoreUrl
    )
}