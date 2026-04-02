package com.alqiran.portfoliomain.data.mapper

import com.alqiran.portfoliomain.data.datasourses.remote.model.Education
import com.alqiran.portfoliomain.data.datasourses.remote.model.Skill
import com.alqiran.portfoliomain.ui.model.EducationUiModel
import com.alqiran.portfoliomain.ui.model.SkillUiModel

fun SkillUiModel.toSkill(): Skill {
    return Skill(
        id = this.id,
        skillName = this.skillName
    )
    
}