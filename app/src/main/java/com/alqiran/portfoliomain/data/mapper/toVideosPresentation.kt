package com.alqiran.portfoliomain.data.mapper

import com.alqiran.portfoliomain.data.datasourses.remote.model.VideoPresentation
import com.alqiran.portfoliomain.ui.model.VideoPresentationUiModel

fun List<VideoPresentationUiModel>.toVideosPresentation(): List<VideoPresentation> {
    return this.map { item ->
        VideoPresentation(
            id = item.id,
            videoTitle = item.videoTitle,
            videoUrl = item.videoUrl
        )
    }
}