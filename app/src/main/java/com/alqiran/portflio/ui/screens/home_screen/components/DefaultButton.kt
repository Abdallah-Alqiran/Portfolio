package com.alqiran.portflio.ui.screens.home_screen.components

import android.content.Intent
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.border
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.core.net.toUri
import com.alqiran.portflio.ui.utils.NavigationType

@Composable
fun DefaultButton(
    text: String,
    navigationType: NavigationType
) {
    val context = LocalContext.current

    Box(
        modifier = Modifier
            .fillMaxWidth(),
        contentAlignment = Alignment.Center
    ) {
        val interactionSource = remember { MutableInteractionSource() }
        val isPressed by interactionSource.collectIsPressedAsState()

        val backgroundColor by animateColorAsState(
            label = "CV View Button",
            targetValue = if (isPressed)
                MaterialTheme.colorScheme.secondaryContainer
            else MaterialTheme.colorScheme.primaryContainer
        )

        val scale: Float by animateFloatAsState(
            targetValue = if (isPressed) 0.95f else 1f,
            label = "CV View Button"
        )

        val borderColor by animateColorAsState(
            targetValue = if (isPressed) MaterialTheme.colorScheme.primaryContainer else Color.Transparent,
            label = "CV View Button"
        )

        val borderWidth by animateDpAsState(
            targetValue = if (isPressed) 3.dp else 0.dp,
            label = "CV View Button"
        )

        val elevation = if (isPressed) 2.dp else 8.dp

        Button(
            onClick = {
                when (navigationType) {
                    is NavigationType.IntentNavigation -> {
                        context.startActivity(
                            Intent(
                                Intent.ACTION_VIEW,
                                (navigationType.url).toUri()
                            )
                        )
                    }
                    is NavigationType.ScreenNavigation -> {
                        navigationType.onNavigate(
                            navigationType.navigationAction
                        )
                    }
                }
            },
            interactionSource = interactionSource,
            colors = ButtonDefaults.buttonColors(
                containerColor = backgroundColor,
                contentColor = MaterialTheme.colorScheme.primary
            ),
            shape = RoundedCornerShape(16.dp),
            elevation = ButtonDefaults.buttonElevation(
                defaultElevation = elevation,
                pressedElevation = 0.dp,
                disabledElevation = 0.dp
            ),
            modifier = Modifier
                .padding(horizontal = 18.dp)
                .scale(scale)
                .border(borderWidth, borderColor, RoundedCornerShape(16.dp))
        ) {
            Text(text = text)
        }
    }
}