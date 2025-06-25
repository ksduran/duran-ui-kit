package com.kevinduran.duran_ui_kit.dialogs

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog


@Composable
fun DuranDialog(
    title: String,
    visible: Boolean,
    message: String,
    cancelButtonText: String = "Cancel",
    confirmButtonText: String = "Confirmar",
    onCancelButtonPressed: () -> Unit = {},
    onConfirmButtonPressed: () -> Unit = {},
    confirmButtonColor: Color? = null,
    confirmButtonForeground: Color? = null,
    titleColor: Color? = null,
    showCancelButton: Boolean = true,
    showConfirmButton: Boolean = true,
    onDismiss: () -> Unit
) {

    if(visible) {
        Box(Modifier.fillMaxSize()) {
            Dialog(onDismissRequest = onDismiss) {
                Box(Modifier
                    .padding(horizontal = 10.dp)
                    .background(
                        MaterialTheme.colorScheme.surfaceContainer,
                        RoundedCornerShape(topStart = 0.dp, topEnd = 60.dp, bottomEnd = 0.dp, bottomStart = 60.dp)
                    )
                    .fillMaxWidth()
                    .padding(16.dp)
                ) {
                    Column {
                        Text(
                            text = title,
                            style = MaterialTheme.typography.titleLarge,
                            color = titleColor ?: MaterialTheme.colorScheme.onSurface,
                            fontWeight = FontWeight.ExtraBold,
                            modifier = Modifier.padding(vertical = 10.dp)
                        )
                        Text(message, modifier = Modifier.padding(vertical = 10.dp))
                        Row(Modifier.padding(vertical = 10.dp)) {
                            if(showCancelButton) {
                                FilledTonalButton(
                                    onClick = onCancelButtonPressed,
                                    modifier = Modifier.weight(1f).height(50.dp),
                                    shape = RoundedCornerShape(10.dp)
                                ) {
                                    Text(cancelButtonText)
                                }
                            }
                            if(showCancelButton && showConfirmButton) Spacer(Modifier.width(8.dp))
                            Spacer(Modifier.width(8.dp))
                            if(showConfirmButton) {
                                Button(
                                    onClick = onConfirmButtonPressed,
                                    modifier = Modifier.weight(1f).height(50.dp),
                                    shape = RoundedCornerShape(10.dp),
                                    colors = ButtonDefaults.buttonColors().copy(
                                        containerColor = confirmButtonColor ?: MaterialTheme.colorScheme.primary,
                                        contentColor = confirmButtonForeground ?: MaterialTheme.colorScheme.surface
                                    )
                                ) {
                                    Text(confirmButtonText)
                                }
                            }
                        }
                    }
                }
            }

        }
    }

}

