package com.alqiran.portflio.ui.screens.project_item_screen

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import com.alqiran.portflio.ui.screens.viewModels.UserViewModel

@Composable
fun ProjectItemScreen(projectId: Int) {

    val userViewModel = viewModel<UserViewModel>()
    val project = userViewModel.getProject(projectId)

    Text(project.toString())

}