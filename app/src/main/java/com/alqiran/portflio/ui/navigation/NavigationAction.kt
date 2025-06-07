package com.alqiran.portflio.ui.navigation

import com.alqiran.portflio.ui.model.CourseUiModel
import com.alqiran.portflio.ui.model.ProjectUiModel
import kotlinx.serialization.Serializable

sealed class NavigationAction {

    object Nothing: NavigationAction()

    data class ToProject(val project: ProjectUiModel): NavigationAction()

    data class ToViewAllProjects(val projects: List<ProjectUiModel>): NavigationAction()
    data class ToViewAllCourses(val courses: List<CourseUiModel>): NavigationAction()


}