package com.alqiran.portflio.ui.screens.home_screen


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
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
import com.alqiran.portflio.ui.screens.home_screen.components.CVButton
import com.alqiran.portflio.ui.screens.home_screen.components.TechnologiesAndToolsSection
import com.alqiran.portflio.ui.screens.home_screen.components.TopTitleSection
import com.alqiran.portflio.ui.screens.home_screen.model.Technology
import com.alqiran.portflio.ui.screens.home_screen.model.TechnologyTitle
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
            .padding(top = 32.dp)
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
            CVButton(userData.cvUrl!!, context)
        }

        if (userData.about != null) {
            AboutSection(userData.about)
        }

        if (userData.technologiesAndTools != null) {
            TechnologiesAndToolsSection(userData.technologiesAndTools)
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