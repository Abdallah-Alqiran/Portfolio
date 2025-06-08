package com.alqiran.portfoliomain.ui.helper

import android.util.Patterns

fun String?.isValidUrl(): Boolean {
    return this != null && Patterns.WEB_URL.matcher(this).matches()
}