package com.alqiran.portfoliomain.data.mapper

import com.alqiran.portfoliomain.data.datasourses.remote.model.Project
import com.alqiran.portfoliomain.ui.model.ProjectUiModel

fun ProjectUiModel.toProject(): Project {
    return Project(
        id = this.id,
        image = this.image,
        projectName = this.projectName,
        description = this.description,
        githubUrl = this.githubUrl,
        googlePlayUrl = this.googlePlayUrl,
        appleStoreUrl = this.appleStoreUrl,
    )
    
}