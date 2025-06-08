package com.alqiran.portfoliomain.ui.utils

import android.content.Context
import com.alqiran.portfoliomain.ui.navigation.NavigationAction

sealed class ButtonType {

    data class IntentNavigation(val url: String, val context: Context): ButtonType()

    data class ScreenNavigation(val onNavigate: (NavigationAction) -> Unit, val navigationAction: NavigationAction): ButtonType()

    data class MessageOnClick(val onSendMessage:()->Unit): ButtonType()
}