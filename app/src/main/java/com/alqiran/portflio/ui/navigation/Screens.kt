package com.alqiran.portflio.ui.navigation

sealed class Screens(val route: String) {
    data object SplashScreenRoute: Screens("splash")

    data object HomeScreenRoute : Screens("home")

    data object ProjectItemRoute: Screens("project_item")

    data object ProjectsScreenRoute: Screens("projects")
    data object CoursesScreenRoute: Screens("courses")
}