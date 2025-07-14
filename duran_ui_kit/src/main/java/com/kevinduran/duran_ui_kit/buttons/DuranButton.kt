package com.kevinduran.duran_ui_kit.buttons

import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.rounded.KeyboardArrowRight
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em

@Composable
fun DuranButton(
    modifier: Modifier = Modifier,
    text: String,
    backgroundColor: Color? = null,
    foreground: Color? = null,
    showIcon: Boolean = true,
    icon: @Composable (() -> Unit)? = null,
    enabled: Boolean = true,
    onClick: () -> Unit
) {
    Button(
        enabled = enabled,
        onClick = onClick,
        modifier = modifier.requiredWidth(width = 180.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = backgroundColor ?: MaterialTheme.colorScheme.primary,
            contentColor = foreground ?: MaterialTheme.colorScheme.surface
        ),
        shape = MaterialTheme.shapes.medium
    ) {
        Text(
            text = text,
            lineHeight = 1.5.em,
            style = MaterialTheme.typography.bodyMedium
        )
        if(showIcon) {
            icon ?: Icon(
                imageVector = Icons.AutoMirrored.Rounded.KeyboardArrowRight,
                contentDescription = null,
            )
        }
    }
}