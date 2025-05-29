package com.alqiran.portflio.ui.navigation

import com.alqiran.portflio.ui.screens.home_screen.model.Course
import com.alqiran.portflio.ui.screens.home_screen.model.Project

sealed class NavigationAction {

    object Nothing: NavigationAction()

    data class ToProject(val projectId: String): NavigationAction()

    data class ToViewAllProjects(val projects: List<Project>): NavigationAction()
    data class ToViewAllCourses(val courses: List<Course>): NavigationAction()


}