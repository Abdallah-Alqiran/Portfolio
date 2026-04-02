package com.alqiran.portfoliomain.data.mapper

import com.alqiran.portfoliomain.data.datasourses.remote.model.Education
import com.alqiran.portfoliomain.data.datasourses.remote.model.Technology
import com.alqiran.portfoliomain.ui.model.EducationUiModel
import com.alqiran.portfoliomain.ui.model.TechnologyUiModel

fun TechnologyUiModel.toTechnology(): Technology {
    return Technology(
        id = this.id,
        technologyName = this.technologyName,
    )
    
}