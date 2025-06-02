package com.alqiran.portflio.ui.screens.projects_screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.hilt.navigation.compose.hiltViewModel
import com.alqiran.portflio.ui.navigation.NavigationAction
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.alqiran.portflio.ui.components.FailedLoadingScreen
import com.alqiran.portflio.ui.components.LoadingProgressIndicator
import com.alqiran.portflio.ui.screens.projects_screen.viewModel.ProjectsState
import com.alqiran.portflio.ui.screens.projects_screen.viewModel.ProjectsViewModel


@Composable
fun ProjectsScreen(onNavigate: (NavigationAction) -> Unit) {
    val projectsViewModel = hiltViewModel<ProjectsViewModel>()
    val projectsState by projectsViewModel.projectState.collectAsStateWithLifecycle()

    LaunchedEffect(Unit) {
        projectsViewModel.fetchAllProjects()
    }

    when (projectsState) {
        is ProjectsState.Error -> {
            FailedLoadingScreen(
                onFailed = { projectsViewModel.fetchAllProjects() },
                errorMessage = (projectsState as ProjectsState.Error).error
            )
        }
        ProjectsState.Loading -> {
            LoadingProgressIndicator()
        }
        is ProjectsState.Success -> {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .verticalScroll(rememberScrollState()),
            ) {
                Text((projectsState as ProjectsState.Success).projects.toString())
            }
        }
        ProjectsState.None -> Unit
    }


}