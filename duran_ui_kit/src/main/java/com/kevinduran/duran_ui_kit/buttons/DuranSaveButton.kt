package com.kevinduran.duran_ui_kit.buttons

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun DuranSaveButton(
    modifier: Modifier = Modifier,
    text: String = "Guardar",
    enabled: Boolean? = null,
    onSave: () -> Unit
) {
    var isSaved by remember { mutableStateOf(false) }

    Button(
        onClick = {
            enabled?.let {
                onSave()
                return@Button
            }
            if (!isSaved) {
                onSave()
                isSaved = true
            }
        },
        enabled = !isSaved,
        shape = RoundedCornerShape(12.dp),
        modifier = modifier.padding(end = 8.dp)
    ) {
        Text(text = text, fontSize = 14.sp)
    }
}
