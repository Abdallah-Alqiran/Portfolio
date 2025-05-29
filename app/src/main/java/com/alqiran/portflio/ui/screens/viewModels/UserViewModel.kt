package com.alqiran.portflio.ui.screens.viewModels

import androidx.lifecycle.ViewModel
import com.alqiran.portflio.ui.screens.home_screen.model.Course
import com.alqiran.portflio.ui.screens.home_screen.model.Project
import com.alqiran.portflio.ui.screens.home_screen.model.UserUiModel
import com.alqiran.portflio.ui.screens.home_screen.preview.fakeUserDataModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class UserViewModel : ViewModel() {
    val fakeUserData = fakeUserDataModel

    private val _userData = MutableStateFlow<UserUiModel>(fakeUserData)
    val userData = _userData.asStateFlow()

    fun getAllProjects(): List<Project>? {
        return _userData.value.projects
    }

    fun getAllCourses(): List<Course>? {
        return _userData.value.courses
    }

    fun getProject(id: Int): Project? {
        return _userData.value.projects!![id]
    }
}