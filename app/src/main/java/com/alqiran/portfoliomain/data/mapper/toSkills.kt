package com.alqiran.portfoliomain.data.mapper

import com.alqiran.portfoliomain.data.datasourses.remote.model.Skill
import com.alqiran.portfoliomain.ui.model.SkillUiModel

fun List<SkillUiModel>.toSkills(): List<Skill> {
    return this.map { item ->
        Skill(
            id = item.id,
            skillName = item.skillName
        )
    }
}