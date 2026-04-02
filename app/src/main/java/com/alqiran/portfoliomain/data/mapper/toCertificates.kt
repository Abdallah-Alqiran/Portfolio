package com.alqiran.portfoliomain.data.mapper

import com.alqiran.portfoliomain.data.datasourses.remote.model.Certificate
import com.alqiran.portfoliomain.data.datasourses.remote.model.Education
import com.alqiran.portfoliomain.data.datasourses.remote.model.Project
import com.alqiran.portfoliomain.ui.model.CertificateUiModel
import com.alqiran.portfoliomain.ui.model.EducationUiModel
import com.alqiran.portfoliomain.ui.model.ProjectUiModel
import kotlin.String

fun List<CertificateUiModel>.toCertificates(): List<Certificate> {
    return this.map { item ->
        Certificate(
            id = item.id,
            certificateName = item.certificateName,
            imageUrl = item.imageUrl,
            description = item.description,
        )
    }
}