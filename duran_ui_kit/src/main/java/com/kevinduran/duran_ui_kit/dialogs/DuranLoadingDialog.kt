package com.kevinduran.duran_ui_kit.dialogs

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog

@Composable
fun DuranLoadingDialog(
    visible: Boolean,
    loading: @Composable (() -> Unit)? = null,
    loadingText: String = "Un momento",
    showLoadingText: Boolean = true,
    onDismiss: () -> Unit
) {

    if(visible) {
        Box(Modifier.fillMaxSize()) {
            Dialog(onDismissRequest = onDismiss) {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    loading ?: CircularProgressIndicator(color = Color.White)
                    Text(
                        text = loadingText,
                        color = Color.White,
                        style = MaterialTheme.typography.headlineLarge,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(vertical = 10.dp)
                    )
                }
            }

        }
    }

}
