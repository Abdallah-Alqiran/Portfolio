package com.alqiran.portflio.ui.screens.courses_screen

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.alqiran.portflio.ui.navigation.NavigationAction
import com.alqiran.portflio.ui.screens.viewModels.UserViewModel

@Composable
fun CoursesScreen() {
    val userViewModel = viewModel<UserViewModel>()
    val courses = userViewModel.getAllCourses()

    Text(courses.toString())

}