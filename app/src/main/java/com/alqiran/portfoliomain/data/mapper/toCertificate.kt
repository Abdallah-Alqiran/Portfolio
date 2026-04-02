package com.alqiran.portfoliomain.data.mapper

import com.alqiran.portfoliomain.data.datasourses.remote.model.Certificate
import com.alqiran.portfoliomain.data.datasourses.remote.model.Education
import com.alqiran.portfoliomain.data.datasourses.remote.model.Project
import com.alqiran.portfoliomain.ui.model.CertificateUiModel
import com.alqiran.portfoliomain.ui.model.EducationUiModel
import com.alqiran.portfoliomain.ui.model.ProjectUiModel
import kotlin.String

fun CertificateUiModel.toCertificate(): Certificate {
    return Certificate(
        id = this.id,
        certificateName = this.certificateName,
        imageUrl = this.imageUrl,
        description = this.description,
    )

}