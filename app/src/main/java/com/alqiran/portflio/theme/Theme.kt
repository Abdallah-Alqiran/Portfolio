package com.alqiran.portflio.theme

import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext

private val DarkColorScheme = darkColorScheme(
    background = Color(0xFF131313),
    surface = Color(0xFF181F2B),
    primary = Color(0xFFF8FAFC),
    secondary = Color(0xFF3B82F6),
    tertiary = Color(0xFF00BFA6),
    onBackground = Color(0xFFF8FAFC),
    primaryContainer = Color(0xFF00BCD4),
    secondaryContainer = Color(0xFF00E777),
)

private val LightColorScheme = lightColorScheme(
    background = Color(0xFFF8FAFC),
    surface = Color(0xFFEFF3F8),
    primary = Color(0xFF131313),
    secondary = Color(0xFF3B82F6),
    tertiary = Color(0xFF00BFA6),
    onBackground = Color(0xFF131313),
    primaryContainer = Color(0xFF00BCD4),
    secondaryContainer = Color(0xFF00E676),
)


@Composable
fun PortflioTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = true,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
//        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
//            val context = LocalContext.current
//            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
//        }

        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}