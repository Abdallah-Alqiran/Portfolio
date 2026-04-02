package com.alqiran.portfoliomain.data.mapper

import com.alqiran.portfoliomain.data.datasourses.remote.model.Technology
import com.alqiran.portfoliomain.data.datasourses.remote.model.TechnologyTitle
import com.alqiran.portfoliomain.ui.model.TechnologyTitleUiModel

fun TechnologyTitleUiModel.toTechnologyAndTool(): TechnologyTitle {
    return TechnologyTitle(
        id = this.id,
        technologyTitle = this.technologyTitle,
        technologies = this.technologies.map { tech ->
            Technology(
                id = tech.id,
                technologyName = tech.technologyName
            )
        },
    )
}