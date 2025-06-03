package com.alqiran.portflio.ui.mapper

fun String.toFormatGoogleDriveLink(): String {
    return if (this.startsWith("https://drive.google.com/uc?export=view&id=")) {
        this
    } else {
        "https://drive.google.com/uc?export=view&id=$this"
    }
}