package com.alqiran.portflio.ui.screens.projects_screen

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import com.alqiran.portflio.ui.navigation.NavigationAction
import com.alqiran.portflio.ui.screens.viewModels.UserViewModel

@Composable
fun ProjectsScreen(onNavigate: (NavigationAction) -> Unit) {
    val userViewModel = viewModel<UserViewModel>()
    val projects = userViewModel.getAllProjects()

    Text(projects.toString())


}