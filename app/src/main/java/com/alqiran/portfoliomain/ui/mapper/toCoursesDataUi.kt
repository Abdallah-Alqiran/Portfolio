package com.alqiran.portfoliomain.ui.mapper

import com.alqiran.portfoliomain.data.datasourses.remote.model.Course
import com.alqiran.portfoliomain.ui.model.CourseUiModel

fun List<Course>.toCoursesDataUi(): List<CourseUiModel> {
    return this.map { item ->
        CourseUiModel(
            id = item.id,
            courseName = item.courseName,
            courseDescription = item.courseDescription
        )
    }
}