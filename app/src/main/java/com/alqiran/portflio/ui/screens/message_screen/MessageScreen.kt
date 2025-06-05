package com.alqiran.portflio.ui.screens.message_screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.alqiran.portflio.theme.PortflioTheme
import com.alqiran.portflio.ui.screens.home_screen.components.DefaultButton
import com.alqiran.portflio.ui.utils.ButtonType

@Composable
fun MessageScreen() {
    Column(
        modifier = Modifier
            .background(MaterialTheme.colorScheme.background)
            .fillMaxSize()
            .padding(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        var email by remember { mutableStateOf("") }
        var message by remember { mutableStateOf("") }

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

        DefaultButton(text = "Send Message", buttonType = ButtonType.ToastMessage("Message Send Successful"))

    }
}

@Composable
fun CustomOutlinedTextFieldWidget(
    textValue: String,
    textLabel: String,
    placeHolderLabel: String,
    isSingleLine: Boolean = true,
    keyboardType: KeyboardType = KeyboardType.Text,
    minLines: Int = 1,
    onTextChange: (String) -> Unit
) {
    OutlinedTextField(
        value = textValue,
        onValueChange = {
            onTextChange(it)
        },
        label = { Text(textLabel) },
        placeholder = { Text(placeHolderLabel) },
        singleLine = isSingleLine,
        modifier = Modifier.fillMaxWidth(),
        keyboardOptions = KeyboardOptions(
            keyboardType = keyboardType,
            imeAction = ImeAction.Next
        ),
        textStyle = MaterialTheme.typography.labelMedium,
        colors = OutlinedTextFieldDefaults.colors(
            focusedBorderColor = MaterialTheme.colorScheme.secondary,
            unfocusedBorderColor = MaterialTheme.colorScheme.outline,
            focusedLabelColor = MaterialTheme.colorScheme.secondary,
            unfocusedLabelColor = MaterialTheme.colorScheme.onSurfaceVariant,
            errorLabelColor = MaterialTheme.colorScheme.error,
            disabledLabelColor = MaterialTheme.colorScheme.primary,
            cursorColor = MaterialTheme.colorScheme.secondary,
            focusedTextColor = MaterialTheme.colorScheme.primary,
            unfocusedTextColor = MaterialTheme.colorScheme.onSurface,
            focusedPlaceholderColor = MaterialTheme.colorScheme.onSurfaceVariant,
            unfocusedPlaceholderColor = MaterialTheme.colorScheme.onSurfaceVariant,
            focusedContainerColor = MaterialTheme.colorScheme.surface,
            unfocusedContainerColor = MaterialTheme.colorScheme.surface,
            errorContainerColor = MaterialTheme.colorScheme.surface,
            disabledContainerColor = MaterialTheme.colorScheme.surface,
        ),
        minLines = minLines
    )
}


@Preview
@Composable
private fun Prev() {
    PortflioTheme {
        MessageScreen()
    }
}