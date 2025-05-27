package com.alqiran.portflio.ui.screens.home_screen.components

import android.content.Context
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.alqiran.portflio.R
import com.alqiran.portflio.ui.components.HeadlineTextWidget
import com.alqiran.portflio.ui.screens.home_screen.model.Project
import kotlin.collections.forEach

@Composable
fun ProjectSection(projects: List<Project>, context: Context) {
    val context = LocalContext.current
    HeadlineTextWidget(text = "Projects")

    Row(
        modifier = Modifier
            .padding(vertical = 16.dp)
            .horizontalScroll(rememberScrollState()),
        horizontalArrangement = Arrangement.Center
    ) {
        projects.forEach { project ->
            Column(
                modifier = Modifier
                    .padding(horizontal = 8.dp)
                    .clip(RoundedCornerShape(16.dp))
                    .background(MaterialTheme.colorScheme.surface)
                    .padding(bottom = 8.dp),
            ) {
                Image(
                    painter = painterResource(id = R.drawable.p1),
                    contentDescription = null,
                    modifier = Modifier
                        .width(240.dp)
                        .aspectRatio(16f / 9f)
                )
                Text(
                    text = project.projectName,
                    style = MaterialTheme.typography.headlineSmall,
                    color = MaterialTheme.colorScheme.primary,
                    modifier = Modifier.padding(8.dp),
                    maxLines = 1,
                )
                Box(
                    modifier = Modifier.width(240.dp),
                    contentAlignment = Alignment.Center
                ) {
                    DefaultButton("Show Details", context = context)
                }
            }
        }
    }
}