package com.alqiran.portflio.ui.screens.home_screen


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.alqiran.portflio.theme.PortflioTheme
import com.alqiran.portflio.ui.components.HeadlineTextWidget
import com.alqiran.portflio.ui.helper.isValidUrl
import com.alqiran.portflio.ui.screens.home_screen.components.AboutSection
import com.alqiran.portflio.ui.screens.home_screen.components.Courses
import com.alqiran.portflio.ui.screens.home_screen.components.DefaultButton
import com.alqiran.portflio.ui.screens.home_screen.components.ProjectSection
import com.alqiran.portflio.ui.screens.home_screen.components.SkillsSection
import com.alqiran.portflio.ui.screens.home_screen.components.TechnologiesAndToolsSection
import com.alqiran.portflio.ui.screens.home_screen.components.TopTitleSection
import com.alqiran.portflio.ui.screens.home_screen.model.Experience
import com.alqiran.portflio.ui.screens.home_screen.preview.fakeUserDataModel

@Composable
fun HomeScreen() {
    val userData = fakeUserDataModel
    val context = LocalContext.current

    Column(
        modifier = Modifier
            .background(MaterialTheme.colorScheme.background)
            .fillMaxSize()
            .padding(horizontal = 8.dp)
            .verticalScroll(rememberScrollState())
    ) {

        TopTitleSection(
            userData.userName,
            userData.userImage,
            userData.jobTitle,
            userData.contactAndAccounts,
            context
        )

        if (userData.cvUrl.isValidUrl()) {
            DefaultButton(text = "Download CV", userData.cvUrl!!, context)
        }

        if (userData.about != null) {
            HeadlineTextWidget(text = "About")
            AboutSection(userData.about)
        }

        if (userData.technologiesAndTools != null) {
            HeadlineTextWidget(text = "Technologies and Tools")
            TechnologiesAndToolsSection(userData.technologiesAndTools)
        }

        if (userData.skills != null) {
            HeadlineTextWidget(text = "Skills")
            SkillsSection(userData.skills)
        }

        if (userData.projects != null) {
            HeadlineTextWidget(text = "Projects")
            ProjectSection(userData.projects, context = context)
        }

        if (userData.courses != null) {
            HeadlineTextWidget(text = "Courses")
            Courses(userData.courses)
        }

        if (userData.experiences != null) {
            HeadlineTextWidget(text = "Experience")
            ExperienceSection(userData.experiences)
        }

        if (userData.education != null) {
            HeadlineTextWidget(text = "Education")
            EducationSection()
        }
    }
}


@Composable
fun ExperienceSection(experiences: List<Experience>) {
    experiences.forEach { experience ->
        Row(
            modifier = Modifier.fillMaxWidth()
                .padding(8.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = experience.experienceTitle,
                color = MaterialTheme.colorScheme.tertiary,
                style = MaterialTheme.typography.headlineSmall
            )
            Text(
                text = experience.date,
                color = MaterialTheme.colorScheme.surfaceTint,
                style = MaterialTheme.typography.bodyMedium
            )
        }
        Text(
            text = experience.description,
            color = MaterialTheme.colorScheme.primary,
            style = MaterialTheme.typography.labelMedium,
            modifier = Modifier.padding(start = 12.dp)
        )

    }
}

@Composable
fun EducationSection(modifier: Modifier = Modifier) {

}

@Composable
fun Contact(modifier: Modifier = Modifier) {

}

@Preview
@Composable
private fun Prev() {
    PortflioTheme {
        HomeScreen()
    }
}