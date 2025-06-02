package com.alqiran.portflio.ui.screens.courses_screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.alqiran.portflio.ui.screens.courses_screen.viewModel.CoursesViewModel
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import com.alqiran.portflio.ui.components.FailedLoadingScreen
import com.alqiran.portflio.ui.components.LoadingProgressIndicator
import com.alqiran.portflio.ui.screens.courses_screen.viewModel.CoursesState

@Composable
fun CoursesScreen() {
    val coursesViewModel = hiltViewModel<CoursesViewModel>()
    val coursesState by coursesViewModel.coursesState.collectAsStateWithLifecycle()
    LaunchedEffect(Unit) {
        coursesViewModel.fetchAllCourses()
    }

    when (coursesState) {
        is CoursesState.Error -> {
            FailedLoadingScreen(
                onFailed = { coursesViewModel.fetchAllCourses() },
                errorMessage = (coursesState as CoursesState.Error).error
            )
        }

        CoursesState.Loading -> {
            LoadingProgressIndicator()
        }

        CoursesState.None -> Unit
        is CoursesState.Success -> {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .verticalScroll(rememberScrollState()),
            ) {
                Text((coursesState as CoursesState.Success).courses.toString())
            }
        }
    }


}