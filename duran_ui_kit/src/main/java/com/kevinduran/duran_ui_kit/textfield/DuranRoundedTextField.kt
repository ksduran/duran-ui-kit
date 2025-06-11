package com.kevinduran.duran_ui_kit.textfield

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@Composable
fun DuranRoundedTextField(
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
        modifier = modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(15.dp))
            .border(
                width = 1.dp,
                color = MaterialTheme.colorScheme.surfaceContainerHighest,
                shape = RoundedCornerShape(15.dp)
            ),
        colors = TextFieldDefaults.colors().copy(
            unfocusedContainerColor = MaterialTheme.colorScheme.surfaceBright,
            focusedContainerColor = MaterialTheme.colorScheme.surfaceBright,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            errorIndicatorColor = MaterialTheme.colorScheme.error,
            disabledIndicatorColor = Color.Transparent,
        )
    )

}