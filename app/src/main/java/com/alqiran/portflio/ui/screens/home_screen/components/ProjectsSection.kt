package com.alqiran.portflio.ui.screens.home_screen.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
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
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.alqiran.portflio.R
import com.alqiran.portflio.ui.navigation.NavigationAction
import com.alqiran.portflio.ui.screens.home_screen.model.ProjectUiModel
import com.alqiran.portflio.ui.utils.NavigationType

@Composable
fun ProjectsSection(projects: List<ProjectUiModel>, onNavigate: (NavigationAction) -> Unit) {

    val listState = rememberLazyListState()

    LazyRow(
        modifier = Modifier
            .padding(vertical = 16.dp),
        state = listState,
        horizontalArrangement = Arrangement.Center
    ) {
        items(projects) { project ->
            Column(
                modifier = Modifier
                    .padding(horizontal = 8.dp)
                    .clip(RoundedCornerShape(16.dp))
                    .background(MaterialTheme.colorScheme.surface)
                    .padding(bottom = 8.dp),
            ) {
                AsyncImage(
                    model = ImageRequest.Builder(context = LocalContext.current)
                        .data(project.image)
                        .crossfade(true)
                        .build(),
                    contentDescription = "Project Image",
                    modifier = Modifier
                        .width(240.dp)
                        .aspectRatio(16f / 9f),
                    placeholder = painterResource(id = R.drawable.profile),
                    error = painterResource(id = R.drawable.ic_launcher_background)
                )
                Text(
                    text = project.projectName,
                    style = MaterialTheme.typography.headlineMedium,
                    color = MaterialTheme.colorScheme.primary,
                    modifier = Modifier.padding(8.dp),
                    maxLines = 1,
                )
                Box(
                    modifier = Modifier.width(240.dp),
                    contentAlignment = Alignment.Center
                ) {
                    DefaultButton(
                        "Show Details",
                        navigationType = NavigationType.ScreenNavigation(
                            navigationAction = NavigationAction.ToProject(project.id.toString()),
                            onNavigate = onNavigate
                        )
                    )
                }
            }
        }
    }
}