package com.alqiran.portfoliomain

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.alqiran.portfoliomain.theme.PortfolioMainTheme
import com.alqiran.portfoliomain.ui.navigation.AppNavHost
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            PortfolioMainTheme {
                AppNavHost()
            }
        }
    }
}

