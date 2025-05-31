package com.alqiran.portflio.ui.mapper

import com.alqiran.portflio.data.datasourses.remote.model.Project
import com.alqiran.portflio.ui.screens.home_screen.model.ProjectUiModel
import com.alqiran.portflio.ui.screens.home_screen.preview.project

fun Project.toProjectItemDataUi(): ProjectUiModel {
    return ProjectUiModel(
        id = this.id,
        image = this.image,
        projectName = this.projectName,
        description = this.description,
        url = this.url
    )
}