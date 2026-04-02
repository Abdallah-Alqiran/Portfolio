package com.alqiran.portfoliomain.ui.screens.home_screen


import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.alqiran.portfoliomain.theme.PortfolioMainTheme
import com.alqiran.portfoliomain.ui.components.HeadlineTextWidget
import com.alqiran.portfoliomain.ui.components.ViewAllTextButton
import com.alqiran.portfoliomain.ui.components.loading_and_failed.FailedLoadingScreen
import com.alqiran.portfoliomain.ui.components.loading_and_failed.LoadingProgressIndicator
import com.alqiran.portfoliomain.ui.helper.isValidUrl
import com.alqiran.portfoliomain.ui.model.CourseUiModel
import com.alqiran.portfoliomain.ui.model.ProjectUiModel
import com.alqiran.portfoliomain.ui.model.UserUiModel
import com.alqiran.portfoliomain.ui.navigation.NavigationAction
import com.alqiran.portfoliomain.ui.screens.home_screen.components.AboutSection
import com.alqiran.portfoliomain.ui.screens.home_screen.components.CertificatesSection
import com.alqiran.portfoliomain.ui.screens.home_screen.components.ContentsSection
import com.alqiran.portfoliomain.ui.screens.home_screen.components.CoursesSection
import com.alqiran.portfoliomain.ui.screens.home_screen.components.DefaultButton
import com.alqiran.portfoliomain.ui.screens.home_screen.components.EducationSection
import com.alqiran.portfoliomain.ui.screens.home_screen.components.ExperienceSection
import com.alqiran.portfoliomain.ui.screens.home_screen.components.ProjectsSection
import com.alqiran.portfoliomain.ui.screens.home_screen.components.SkillsSection
import com.alqiran.portfoliomain.ui.screens.home_screen.components.TechnologiesAndToolsSection
import com.alqiran.portfoliomain.ui.screens.home_screen.components.TopTitleSection
import com.alqiran.portfoliomain.ui.screens.home_screen.components.VideoPresentationsSection
import com.alqiran.portfoliomain.ui.screens.home_screen.viewModel.UserState
import com.alqiran.portfoliomain.ui.screens.home_screen.viewModel.UserViewModel
import com.alqiran.portfoliomain.ui.utils.ButtonType


@Composable
fun HomeScreen(
    onNavigate: (NavigationAction) -> Unit,
    onStart:(List<ProjectUiModel>?, List<CourseUiModel>?) -> Unit
) {

    val userViewModel: UserViewModel = hiltViewModel()
    val userData by userViewModel.userState.collectAsStateWithLifecycle()

    LaunchedEffect(Unit) {
        userViewModel.fetchUserData()
    }

    when (userData) {
        is UserState.Success -> {
            val data = (userData as UserState.Success).userData
            onStart(data.projects, data.courses)
            HomeContentScreen(data, onNavigate)
        }

        is UserState.Error -> {
            FailedLoadingScreen(
                onFailed = {
                    Log.d("Al-qiran", "From Home Screen")
                    userViewModel.fetchUserData()
                },
                errorMessage = (userData as UserState.Error).error
            )
        }

        UserState.Loading -> {
            LoadingProgressIndicator()
        }
        UserState.None -> Unit
    }


}

@Composable
fun HomeContentScreen(userData: UserUiModel, onNavigate: (NavigationAction) -> Unit) {
    val context = LocalContext.current
    val listState = rememberLazyListState()

    LazyColumn(
        modifier = Modifier
            .background(MaterialTheme.colorScheme.background)
            .fillMaxSize()
            .padding(horizontal = 16.dp),
        state = listState,
        contentPadding = PaddingValues(bottom = 32.dp)
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
                DefaultButton(
                    text = "Download CV",
                    buttonType = ButtonType.IntentNavigation(userData.cvUrl!!, context)
                )
            }
        }

        // About Section
        item {
            if (userData.about != null) {
                HeadlineTextWidget(text = "About")
                AboutSection(userData.about)
            }
        }

        // Projects Section
        item {
            if (userData.projects != null) {
                HeadlineTextWidget(text = "Projects")
                ProjectsSection(userData.projects, onNavigate)
                ViewAllTextButton(
                    "Projects",
                    onNavigate = onNavigate,
                    navigateAction = NavigationAction.ToViewAllProjects(userData.projects)
                )
            }
        }

        // Experience Section
        item {
            if (userData.experiences != null) {
                HeadlineTextWidget(text = "Experience")
                ExperienceSection(userData.experiences)
            }
        }

        // Skills Section
        item {
            if (userData.skills != null) {
                HeadlineTextWidget(text = "Skills")
                SkillsSection(userData.skills)
            }
        }


        // Technologies & Tools Section
        item {
            if (userData.technologiesAndTools != null) {
                HeadlineTextWidget(text = "Technologies and Tools")
                TechnologiesAndToolsSection(userData.technologiesAndTools)
            }
        }

        // Courses Section
        item {
            if (userData.courses != null) {
                HeadlineTextWidget(text = "Courses")
                CoursesSection(userData.courses)
                ViewAllTextButton(
                    "Courses",
                    onNavigate = onNavigate,
                    navigateAction = NavigationAction.ToViewAllCourses(userData.courses)
                )
            }
        }

        // Certificates Section
        item {
            if (userData.certificates != null ) {
                HeadlineTextWidget(text = "Certificates")
                CertificatesSection(userData.certificates, onNavigate)
            }
        }

        // Contents Section
        item {
            if (userData.contentsTitle != null ) {
                HeadlineTextWidget(text = "Resources")
                ContentsSection(userData.contentsTitle)
            }
        }

        // Video Presentation
        item {
            if (userData.videos != null) {
                HeadlineTextWidget(text = "Videos")
                VideoPresentationsSection(userData.videos)
            }
        }

        // Education Section
        item {
            if (userData.education != null) {
                HeadlineTextWidget(text = "Education")
                EducationSection(userData.education)
            }
        }
    }
}


@Preview
@Composable
private fun Prev() {
    PortfolioMainTheme {
        HomeScreen(
            onNavigate = {},
            onStart = {_,_ ->}
        )
    }
}