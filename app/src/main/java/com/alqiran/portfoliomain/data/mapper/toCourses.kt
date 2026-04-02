package com.alqiran.portfoliomain.data.mapper

import com.alqiran.portfoliomain.data.datasourses.remote.model.Course
import com.alqiran.portfoliomain.data.datasourses.remote.model.Skill
import com.alqiran.portfoliomain.ui.model.CourseUiModel
import com.alqiran.portfoliomain.ui.model.SkillUiModel

fun List<CourseUiModel>.toCourses(): List<Course> {
    return this.map { item ->
        Course(
            id = item.id,
            courseName = item.courseName,
            courseDescription = item.courseDescription
        )
    }
}