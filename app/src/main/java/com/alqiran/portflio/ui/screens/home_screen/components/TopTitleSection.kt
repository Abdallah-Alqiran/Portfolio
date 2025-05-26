package com.alqiran.portflio.ui.screens.home_screen.components

import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.alqiran.portflio.R
import com.alqiran.portflio.ui.helper.isValidUrl
import com.alqiran.portflio.ui.screens.home_screen.model.ContactAndAccounts


@Composable
fun TopTitleSection(
    userName: String,
    userImage: String?,
    jobTitle: String,
    accounts: List<ContactAndAccounts>?,
    context: Context
) {

    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        AsyncImage(
            model = ImageRequest.Builder(context = LocalContext.current)
                .data(userImage)
                .crossfade(true)
                .build(),
            contentDescription = "User Image",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(150.dp)
                .clip(CircleShape)
                .background(MaterialTheme.colorScheme.surface),
            placeholder = painterResource(id = R.drawable.profile),
            error = painterResource(id = R.drawable.profile)
        )

        Text(text = userName, style =  MaterialTheme.typography.headlineLarge, color =  MaterialTheme.colorScheme.primary)
        Text(text = jobTitle, style =  MaterialTheme.typography.headlineMedium, color =  MaterialTheme.colorScheme.tertiary)

        Row(
            modifier = Modifier
                .padding(top = 8.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {

            accounts!!.forEach { item ->
                val imageRes = when(item.webName) {
                    "facebook" -> R.drawable.ic_facebook
                    "linkedin" -> R.drawable.ic_linkedin
                    "whatsapp" -> R.drawable.ic_whatsapp
                    else -> R.drawable.notification
                }

                Image(
                    painter = painterResource(id = imageRes),
                    contentDescription = "icon image",
                    modifier = Modifier
                        .height(36.dp)
                        .clip(CircleShape)
                        .padding(horizontal = 4.dp)
                        .clickable {
                            if (item.url.isValidUrl()) {
                                val intent = Intent(Intent.ACTION_VIEW, Uri.parse(item.url))
                                context.startActivity(intent)
                            }
                        }
                )
            }
        }
    }
}