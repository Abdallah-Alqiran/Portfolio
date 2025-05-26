package com.alqiran.portflio.ui.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.alqiran.portflio.ui.screens.home_screen.HomeScreen

@Composable
fun AppNavHost() {

    val navController = rememberNavController()

    Scaffold(
        topBar = {

        }
    ) { paddingValues ->
        NavHost(
            navController = navController,
            startDestination = Screens.HomeScreen.route,
            modifier = Modifier.padding(paddingValues)
        ) {

            // Splash

            // Home Screen
            composable(Screens.HomeScreen.route) {
                HomeScreen()
            }
        }
    }
}