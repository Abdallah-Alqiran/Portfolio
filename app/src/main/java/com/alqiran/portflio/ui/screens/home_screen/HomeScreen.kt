package com.alqiran.portflio.ui.screens.home_screen

import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
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
import com.alqiran.portflio.ui.screens.home_screen.components.TopTitleSection
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

@Composable
fun CVButton(cvUrl: String, context: Context) {
    Button(
        modifier = Modifier.background(MaterialTheme.colorScheme.surface),
        onClick = {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(cvUrl))
            context.startActivity(intent)

    }) {
        Text(
            text = "Check My CV",
            color = MaterialTheme.colorScheme.primary,
            style = MaterialTheme.typography.labelLarge
        )
    }
}
@Composable
fun TechnologiesAndToolsSection(
    technologiesAndTools: List<TechnologyTitle>
) {
    
}

@Preview
@Composable
private fun Prev() {
    PortflioTheme {
        HomeScreen()
    }
}