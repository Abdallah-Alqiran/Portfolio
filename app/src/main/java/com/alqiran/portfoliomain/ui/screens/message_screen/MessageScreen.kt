package com.alqiran.portfoliomain.ui.screens.message_screen

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.alqiran.portfoliomain.theme.PortfolioMainTheme
import com.alqiran.portfoliomain.ui.components.loading_and_failed.LoadingProgressIndicator
import com.alqiran.portfoliomain.ui.model.ContactMessageUiModel
import com.alqiran.portfoliomain.ui.screens.home_screen.components.DefaultButton
import com.alqiran.portfoliomain.ui.screens.message_screen.components.CustomOutlinedTextFieldWidget
import com.alqiran.portfoliomain.ui.screens.message_screen.viewModel.MessageState
import com.alqiran.portfoliomain.ui.screens.message_screen.viewModel.MessageViewModel
import com.alqiran.portfoliomain.ui.utils.ButtonType

@Composable
fun MessageScreen() {

    val context = LocalContext.current

    val messageViewModel = hiltViewModel<MessageViewModel>()
    val messageState = messageViewModel.messageState.collectAsStateWithLifecycle()

    var email by remember { mutableStateOf("") }
    var message by remember { mutableStateOf("") }

    when (messageState.value) {
        is MessageState.Error -> {
            Toast.makeText(
                context,
                (messageState.value as MessageState.Error).error,
                Toast.LENGTH_SHORT
            ).show()
            messageViewModel.resetState()
        }

        MessageState.Loading -> {
            LoadingProgressIndicator()
        }

        MessageState.Success -> {
            Toast.makeText(context, "Data Saved Successfully", Toast.LENGTH_SHORT).show()
            email = ""
            message = ""
            messageViewModel.resetState()
        }

        MessageState.None -> Unit
    }

    Column(
        modifier = Modifier
            .background(MaterialTheme.colorScheme.background)
            .fillMaxSize()
            .padding(8.dp)
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(
            text = "I’m open to communication — feel free to reach out at any time.",
            color = MaterialTheme.colorScheme.primary,
            style = MaterialTheme.typography.labelMedium,
        )

        Spacer(Modifier.padding(8.dp))

        CustomOutlinedTextFieldWidget(
            textValue = email,
            textLabel = "Email",
            placeHolderLabel = "Enter your Email",
            keyboardType = KeyboardType.Email
        ) {
            email = it
        }

        Spacer(Modifier.padding(8.dp))

        CustomOutlinedTextFieldWidget(
            textValue = message,
            textLabel = "Message",
            placeHolderLabel = "Enter your Message",
            minLines = 5,
            isSingleLine = false
        ) {
            message = it
        }

        Spacer(Modifier.padding(16.dp))

        DefaultButton(text = "Send Message", buttonType = ButtonType.MessageOnClick {
            messageViewModel.sendMessage(ContactMessageUiModel(email = email, message = message))
        })
    }

}


@Preview
@Composable
private fun Prev() {
    PortfolioMainTheme {
        MessageScreen()
    }
}