package com.alqiran.portfoliomain.data.mapper

import com.alqiran.portfoliomain.data.datasourses.remote.model.Content
import com.alqiran.portfoliomain.data.datasourses.remote.model.ContentTitle
import com.alqiran.portfoliomain.data.datasourses.remote.model.Education
import com.alqiran.portfoliomain.data.datasourses.remote.model.Project
import com.alqiran.portfoliomain.data.datasourses.remote.model.Technology
import com.alqiran.portfoliomain.data.datasourses.remote.model.TechnologyTitle
import com.alqiran.portfoliomain.ui.model.ContactAndAccountsUiModel
import com.alqiran.portfoliomain.ui.model.ContentTitleUiModel
import com.alqiran.portfoliomain.ui.model.EducationUiModel
import com.alqiran.portfoliomain.ui.model.ProjectUiModel
import com.alqiran.portfoliomain.ui.model.TechnologyTitleUiModel

fun ContentTitleUiModel.toContentAndTitle(): ContentTitle {
    return ContentTitle(
        id = this.id,
        contentTitle = this.contentTitle,
        contents = this.contents.map { content ->
            Content(
                id = content.id,
                contentDescription = content.contentDescription,
                contentUrl = content.contentUrl
            )
        },
    )
}