package com.alqiran.portflio.ui.mapper

import com.alqiran.portflio.data.datasourses.remote.model.Project
import com.alqiran.portflio.ui.screens.home_screen.model.ProjectUiModel
import com.alqiran.portflio.ui.screens.home_screen.preview.project

fun List<Project>.toProjectsDataUi(): List<ProjectUiModel> {
    return this.map { item ->
        ProjectUiModel(
            id = item.id,
            image = item.image.toFormatGoogleDriveLink(),
            projectName = item.projectName,
            description = item.description,
            url = item.url
        )
    }
}