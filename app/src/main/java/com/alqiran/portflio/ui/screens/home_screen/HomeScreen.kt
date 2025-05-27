package com.alqiran.portflio.ui.screens.home_screen


import android.content.Context
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.alqiran.portflio.R
import com.alqiran.portflio.theme.PortflioTheme
import com.alqiran.portflio.ui.components.HeadlineTextWidget
import com.alqiran.portflio.ui.helper.isValidUrl
import com.alqiran.portflio.ui.screens.home_screen.components.AboutSection
import com.alqiran.portflio.ui.screens.home_screen.components.DefaultButton
import com.alqiran.portflio.ui.screens.home_screen.components.ProjectSection
import com.alqiran.portflio.ui.screens.home_screen.components.TechnologiesAndToolsSection
import com.alqiran.portflio.ui.screens.home_screen.components.TopTitleSection
import com.alqiran.portflio.ui.screens.home_screen.model.Project
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
            AboutSection(userData.about)
        }

        if (userData.technologiesAndTools != null) {
            TechnologiesAndToolsSection(userData.technologiesAndTools)
        }

        if (userData.projects != null) {
            ProjectSection(userData.projects, context = context)
        }
    }
}


@Preview
@Composable
private fun Prev() {
    PortflioTheme {
        HomeScreen()
    }
}