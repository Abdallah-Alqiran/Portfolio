package com.alqiran.portfoliomain.data.mapper

import com.alqiran.portfoliomain.data.datasourses.remote.model.VideoPresentation
import com.alqiran.portfoliomain.ui.model.VideoPresentationUiModel

fun VideoPresentationUiModel.toVideoPresentation(): VideoPresentation {
    return VideoPresentation(
        id = this.id,
        videoTitle = this.videoTitle,
        videoUrl = this.videoUrl
    )
}