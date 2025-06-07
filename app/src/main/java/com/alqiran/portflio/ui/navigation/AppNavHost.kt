package com.alqiran.portflio.ui.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.alqiran.portflio.ui.components.bars.BottomBar
import com.alqiran.portflio.ui.components.bars.TopBar
import com.alqiran.portflio.ui.model.ProjectUiModel
import com.alqiran.portflio.ui.screens.courses_screen.CoursesScreen
import com.alqiran.portflio.ui.screens.home_screen.HomeScreen
import com.alqiran.portflio.ui.screens.message_screen.MessageScreen
import com.alqiran.portflio.ui.screens.project_item_screen.ProjectItemScreen
import com.alqiran.portflio.ui.screens.projects_screen.ProjectsScreen
import com.alqiran.portflio.ui.screens.splash.SplashScreen
import kotlin.reflect.typeOf


@Composable
fun AppNavHost() {
    val navController = rememberNavController()

    val topBar = remember { mutableStateOf("") }
    var selectedIndex by remember { mutableIntStateOf(-1) }


    val onNavigate: (NavigationAction) -> Unit = { action ->
        when (action) {
            is NavigationAction.ToProject -> {
                navController.navigate(ProjectItemRoute(project = action.project))
            }

            is NavigationAction.ToViewAllCourses -> {
                navController.navigate(CoursesScreenRoute)
            }
            is NavigationAction.ToViewAllProjects -> {
                navController.navigate(ProjectsScreenRoute)
            }
            NavigationAction.Nothing -> {}
        }
    }


    Scaffold(
        topBar = {
            when(topBar.value) {
                "Home" -> { TopBar("Home", onClick = {}) }
                "Project" -> { TopBar("Project", onClick = { navController.popBackStack() }) }
                "Projects" -> { TopBar("Projects", onClick = { navController.popBackStack() }) }
                "Courses" -> { TopBar("Courses", onClick = { navController.popBackStack() }) }
                "Message" -> { TopBar("Contact Me", onClick = { navController.popBackStack() }) }
            }
        },
        bottomBar = {
            if (selectedIndex != -1) {
                BottomBar(
                    selectedIndex = selectedIndex,
                    onItemSelected = {
                        selectedIndex = it
                        when (selectedIndex) {
                            0 -> {
                                navController.navigate(HomeScreenRoute) {
                                    popUpTo(0) { inclusive = true }
                                }
                            }
                            1 -> navController.navigate(ProjectsScreenRoute)
                            2 -> navController.navigate(CoursesScreenRoute)
                            3 -> navController.navigate(MessageScreenRoute)
                        }
                    },
                )
            }
        }
    ) { paddingValues ->
        NavHost(
            navController = navController,
            startDestination = SplashScreenRoute,
            modifier = Modifier.padding(paddingValues)
        ) {

            // Splash
            composable<SplashScreenRoute> {
                selectedIndex = -1
                topBar.value = "Splash"
                SplashScreen {
                    navController.navigate(HomeScreenRoute)
                }
            }

            // Home Screen
            composable<HomeScreenRoute> {
                selectedIndex = 0
                topBar.value = "Home"
                HomeScreen(
                    onNavigate
                )
            }

            // Project Item
            composable<ProjectItemRoute>(
                typeMap = mapOf(
                    typeOf<ProjectUiModel>() to CustomNavType.projectItemType
                )
            ) { navBackStackEntry ->
                selectedIndex = 1
                topBar.value = "Project"

                val arguments = navBackStackEntry.toRoute<ProjectItemRoute>()
                ProjectItemScreen (
                    arguments.project
                )
            }

            // All Project Screen
            composable<ProjectsScreenRoute> {
                selectedIndex = 1
                topBar.value = "Projects"
                ProjectsScreen(
                    onNavigate
                )
            }

            // All Courses Screen
            composable<CoursesScreenRoute> {
                selectedIndex = 2
                topBar.value = "Courses"
                CoursesScreen()
            }

            // Message Screen
            composable<MessageScreenRoute> {
                selectedIndex = 3
                topBar.value = "Message"
                MessageScreen()
            }
        }
    }
}