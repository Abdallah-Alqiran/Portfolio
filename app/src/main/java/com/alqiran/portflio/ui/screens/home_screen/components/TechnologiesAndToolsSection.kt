package com.alqiran.portflio.ui.screens.home_screen.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.alqiran.portflio.ui.components.HeadlineTextWidget
import com.alqiran.portflio.ui.screens.home_screen.model.Technology
import com.alqiran.portflio.ui.screens.home_screen.model.TechnologyTitle

@Composable
fun TechnologiesAndToolsSection(
    technologiesAndTools: List<TechnologyTitle>
) {
    HeadlineTextWidget(text = "Technologies and Tools")
    Column(modifier = Modifier.padding(horizontal = 8.dp)) {
        technologiesAndTools.forEach { technologyTitleItem ->
            Text(
                text = technologyTitleItem.technologyTitle,
                color = MaterialTheme.colorScheme.tertiary,
                style = MaterialTheme.typography.headlineSmall
            )
            TwoItemsPerRow(technologies = technologyTitleItem.technologies )
        }
    }
}

@Composable
fun TwoItemsPerRow(technologies: List<Technology>) {
    for (item in technologies.indices step 2) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(4.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ){
            Box(modifier = Modifier.fillMaxWidth(0.5f)) {
                Text(
                    text = technologies[item].technologyName,
                    style = MaterialTheme.typography.headlineSmall,
                    color = MaterialTheme.colorScheme.primary
                )
            }

            if (item + 1 < technologies.size) {
                Text(
                    text = technologies[item+1].technologyName,
                    style = MaterialTheme.typography.headlineSmall,
                    color = MaterialTheme.colorScheme.primary
                )
            }
        }
    }
}