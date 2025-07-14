package com.kevinduran.duran_ui_kit.textfield

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight

@Composable
fun DuranTextField(
    value: String,
    modifier: Modifier = Modifier,
    onValueChange: (String) -> Unit,
    enabled: Boolean = true,
    readOnly: Boolean = false,
    label: String? = null,
    singleLine: Boolean = false,
    keyboardActions: KeyboardActions = KeyboardActions(),
    keyboardOptions: KeyboardOptions = KeyboardOptions(),
    isError: Boolean = false,
    maxLines: Int = Int.MAX_VALUE,
    minLines: Int = 1,
) {
    TextField(
        shape = MaterialTheme.shapes.medium,
        value = value,
        onValueChange = onValueChange,
        enabled = enabled,
        readOnly = readOnly,
        label = {
            Text(label ?: "",
                color = MaterialTheme.colorScheme.outline,
                fontWeight = FontWeight.Medium
            )
        },
        singleLine = singleLine,
        keyboardActions = keyboardActions,
        keyboardOptions = keyboardOptions,
        isError = isError,
        maxLines = maxLines,
        minLines = minLines,
        modifier = modifier.fillMaxWidth(),
        colors = TextFieldDefaults.colors().copy(
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            errorIndicatorColor = MaterialTheme.colorScheme.error,
            disabledIndicatorColor = Color.Transparent,
        )
    )
}