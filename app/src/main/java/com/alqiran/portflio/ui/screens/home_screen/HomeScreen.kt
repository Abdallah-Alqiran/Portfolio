package com.alqiran.portflio.ui.screens.home_screen


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.alqiran.portflio.theme.PortflioTheme
import com.alqiran.portflio.ui.components.HeadlineTextWidget
import com.alqiran.portflio.ui.components.ViewAllTextButton
import com.alqiran.portflio.ui.helper.isValidUrl
import com.alqiran.portflio.ui.navigation.NavigationAction
import com.alqiran.portflio.ui.screens.home_screen.components.AboutSection
import com.alqiran.portflio.ui.screens.home_screen.components.Courses
import com.alqiran.portflio.ui.screens.home_screen.components.DefaultButton
import com.alqiran.portflio.ui.screens.home_screen.components.EducationSection
import com.alqiran.portflio.ui.screens.home_screen.components.ExperienceSection
import com.alqiran.portflio.ui.screens.home_screen.components.ProjectsSection
import com.alqiran.portflio.ui.screens.home_screen.components.SkillsSection
import com.alqiran.portflio.ui.screens.home_screen.components.TechnologiesAndToolsSection
import com.alqiran.portflio.ui.screens.home_screen.components.TopTitleSection
import com.alqiran.portflio.ui.screens.viewModels.UserViewModel
import com.alqiran.portflio.ui.utils.NavigationType

@Composable
fun HomeScreen(
    onNavigate: (NavigationAction) -> Unit
) {

    val userViewModel = viewModel<UserViewModel>()
    val userData = userViewModel.userData.collectAsStateWithLifecycle().value

    val context = LocalContext.current
    val listState = rememberLazyListState()

    LazyColumn (
        modifier = Modifier
            .background(MaterialTheme.colorScheme.background)
            .fillMaxSize()
            .padding(horizontal = 8.dp),
        state = listState
    ) {
        item {
            TopTitleSection(
                userData.userName,
                userData.userImage,
                userData.jobTitle,
                userData.contactAndAccounts,
                context
            )
        }

        item {
            if (userData.cvUrl.isValidUrl()) {
                DefaultButton(text = "Download CV", navigationType = NavigationType.IntentNavigation(userData.cvUrl!!, context))
            }
        }

        item {
            if (userData.education != null) {
                HeadlineTextWidget(text = "Education")
                EducationSection(userData.education)
            }
        }

        item {
            if (userData.about != null) {
                HeadlineTextWidget(text = "About")
                AboutSection(userData.about)
            }
        }

        item {
            if (userData.technologiesAndTools != null) {
                HeadlineTextWidget(text = "Technologies and Tools")
                TechnologiesAndToolsSection(userData.technologiesAndTools)
            }
        }

        item {
            if (userData.skills != null) {
                HeadlineTextWidget(text = "Skills")
                SkillsSection(userData.skills)
            }
        }

        item {
            if (userData.projects != null) {
                HeadlineTextWidget(text = "Projects")
                ProjectsSection(userData.projects, onNavigate)
                ViewAllTextButton("Projects", onNavigate = onNavigate, navigateAction = NavigationAction.ToViewAllProjects(userData.projects))
            }
        }

        item {
            if (userData.courses != null) {
                HeadlineTextWidget(text = "Courses")
                Courses(userData.courses)
                ViewAllTextButton("Courses", onNavigate = onNavigate, navigateAction = NavigationAction.ToViewAllCourses(userData.courses))
            }
        }

        item {
            if (userData.experiences != null) {
                HeadlineTextWidget(text = "Experience")
                ExperienceSection(userData.experiences)
            }
        }
    }
}


@Composable
fun Contact() {

}

@Preview
@Composable
private fun Prev() {
    PortflioTheme {
        HomeScreen(
            onNavigate = {})
    }
}