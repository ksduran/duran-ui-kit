package com.kevinduran.duran_ui_kit.buttons

import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.rounded.KeyboardArrowRight
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em

@Composable
fun DuranTextButton(
    modifier: Modifier = Modifier,
    text: String,
    showIcon: Boolean = true,
    icon: @Composable (() -> Unit)? = null,
    enabled: Boolean = true,
    onClick: () -> Unit
) {
    TextButton(
        enabled = enabled,
        onClick = onClick,
        modifier = modifier.requiredWidth(width = 180.dp),
        shape = MaterialTheme.shapes.medium,
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