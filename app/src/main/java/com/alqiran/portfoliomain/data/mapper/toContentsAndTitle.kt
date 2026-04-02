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

fun List<ContentTitleUiModel>.toContentsAndTitle(): List<ContentTitle> {
    return this.map { item ->
        ContentTitle(
        id = item.id,
        contentTitle = item.contentTitle,
        contents = item.contents.map { content ->
            Content(
                id = content.id,
                contentDescription = content.contentDescription,
                contentUrl = content.contentUrl
            )
        },
        )
    }
}