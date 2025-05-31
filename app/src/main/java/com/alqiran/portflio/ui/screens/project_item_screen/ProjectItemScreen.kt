package com.alqiran.portflio.ui.screens.project_item_screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.alqiran.portflio.ui.screens.project_item_screen.viewModel.ProjectItemViewModel
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import com.alqiran.portflio.ui.screens.project_item_screen.viewModel.ProjectItemState


@Composable
fun ProjectItemScreen(projectId: Int) {

    val projectItemViewModel = hiltViewModel<ProjectItemViewModel>()
    val projectState by projectItemViewModel.projectState.collectAsStateWithLifecycle()

    LaunchedEffect(Unit) {
        projectItemViewModel.fetchProjectItem(projectId)
    }

    when(projectState) {
        is ProjectItemState.Error -> {
            Text((projectState as ProjectItemState.Error).error)
        }
        ProjectItemState.Loading -> {}
        ProjectItemState.None -> {}
        is ProjectItemState.Success -> {
            Column(
                modifier = Modifier.fillMaxSize()
                    .verticalScroll(rememberScrollState()),
            ) {
                Text((projectState as ProjectItemState.Success).project.toString())
            }
        }
    }

}