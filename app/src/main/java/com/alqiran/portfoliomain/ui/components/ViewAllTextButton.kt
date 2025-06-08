package com.alqiran.portfoliomain.ui.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.alqiran.portfoliomain.ui.navigation.NavigationAction

@Composable
fun ViewAllTextButton(
    text: String,
    onNavigate: (NavigationAction) -> Unit,
    navigateAction: NavigationAction
) {
    Box(
        modifier = Modifier.fillMaxWidth(),
        contentAlignment = Alignment.Center
    ) {
        TextButton(
            onClick = {
                onNavigate(navigateAction)
            },
        ) {
            Text(
                "View All $text",
                style = MaterialTheme.typography.labelSmall,
                color = MaterialTheme.colorScheme.primaryContainer,
            )
        }
    }
}