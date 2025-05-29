package com.alqiran.portflio.ui.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.alqiran.portflio.ui.screens.courses_screen.CoursesScreen
import com.alqiran.portflio.ui.screens.home_screen.HomeScreen
import com.alqiran.portflio.ui.screens.project_item_screen.ProjectItemScreen
import com.alqiran.portflio.ui.screens.projects_screen.ProjectsScreen

@Composable
fun AppNavHost() {

    val navController = rememberNavController()


    val onNavigate: (NavigationAction) -> Unit = { action ->
        when (action) {
            is NavigationAction.ToProject -> {
                navController.navigate(Screens.ProjectItemRoute.route)
            }

            is NavigationAction.ToViewAllCourses -> {
                navController.navigate(Screens.CoursesScreenRoute.route)
            }
            is NavigationAction.ToViewAllProjects -> {
                navController.navigate(Screens.ProjectsScreenRoute.route)
            }
            NavigationAction.Nothing -> {}
        }
    }


    Scaffold(
        topBar = {

        }
    ) { paddingValues ->
        NavHost(
            navController = navController,
            startDestination = Screens.HomeScreenRoute.route,
            modifier = Modifier.padding(paddingValues)
        ) {

            // Splash

            // Home Screen
            composable(Screens.HomeScreenRoute.route) {
                HomeScreen(
                    onNavigate
                )
            }

            // Project Item
            composable(Screens.ProjectItemRoute.route) {
                ProjectItemScreen (
                    onNavigate
                )
            }

            // All Project Screen
            composable(Screens.ProjectsScreenRoute.route) {
                ProjectsScreen(
                    onNavigate
                )
            }

            // All Courses Screen
            composable(Screens.CoursesScreenRoute.route) {
                CoursesScreen(
                    onNavigate
                )
            }
        }
    }
}