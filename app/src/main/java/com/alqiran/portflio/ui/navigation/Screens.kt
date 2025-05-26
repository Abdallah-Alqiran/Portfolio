package com.alqiran.portflio.ui.navigation

sealed class Screens(val route: String) {
    data object SplashScreen: Screens("splash")
    data object HomeScreen : Screens("home")
    data object Projects : Screens("projects")
}