package com.alqiran.portfoliomain.data.mapper

import com.alqiran.portfoliomain.data.datasourses.remote.model.Course
import com.alqiran.portfoliomain.data.datasourses.remote.model.Education
import com.alqiran.portfoliomain.data.datasourses.remote.model.Skill
import com.alqiran.portfoliomain.ui.model.CourseUiModel
import com.alqiran.portfoliomain.ui.model.EducationUiModel
import com.alqiran.portfoliomain.ui.model.SkillUiModel

fun CourseUiModel.toCourse(): Course {
    return Course(
        id = this.id,
        courseName = this.courseName,
        courseDescription = this.courseDescription,
    )

}