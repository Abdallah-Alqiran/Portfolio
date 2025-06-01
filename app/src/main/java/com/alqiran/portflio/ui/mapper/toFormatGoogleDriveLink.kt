package com.alqiran.portflio.ui.mapper

fun String.toFormatGoogleDriveLink(): String {
    val regex = Regex("""https://drive\.google\.com/file/d/([a-zA-Z0-9_-]+)/view\?""")
    val match = regex.find(this)

    return if (match != null) {
        val fileId = match.groupValues[1]
        "https://drive.google.com/uc?export=view&id=$fileId"
    } else {
        this
    }
}