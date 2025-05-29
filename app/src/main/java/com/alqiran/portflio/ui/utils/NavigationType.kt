package com.alqiran.portflio.ui.utils

import android.content.Context
import com.alqiran.portflio.ui.navigation.NavigationAction

sealed class NavigationType {

    data class IntentNavigation(val url: String, val context: Context): NavigationType()

    data class ScreenNavigation(val onNavigate: (NavigationAction) -> Unit, val navigationAction: NavigationAction): NavigationType()
}