package com.alqiran.portfoliomain.data.mapper

import com.alqiran.portfoliomain.data.datasourses.remote.model.Content
import com.alqiran.portfoliomain.data.datasourses.remote.model.Education
import com.alqiran.portfoliomain.data.datasourses.remote.model.Technology
import com.alqiran.portfoliomain.ui.model.ContentUiModel
import com.alqiran.portfoliomain.ui.model.EducationUiModel
import com.alqiran.portfoliomain.ui.model.TechnologyUiModel

fun ContentUiModel.toContent(): Content {
    return Content(
        id = this.id,
        contentDescription = this.contentDescription,
        contentUrl = this.contentUrl,
    )
    
}