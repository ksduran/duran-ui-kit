package com.kevinduran.duran_ui_kit.dialogs

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun DuranDeleteDialog(
    visible: Boolean,
    message: String,
    onDismiss: () -> Unit,
    onDelete: () -> Unit
) {
    if (!visible) return

    Box(Modifier.fillMaxSize()) {
        AlertDialog(
            onDismissRequest = onDismiss,
            confirmButton = {
                Button(
                    onClick = {
                        onDelete()
                        onDismiss()
                    },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.Red,
                        contentColor = Color.White
                    ),
                    elevation = ButtonDefaults.buttonElevation(10.dp),
                    modifier = Modifier.height(50.dp)
                ) {
                    Text(text = "Eliminar", fontSize = 16.sp)
                }
            },
            title = {
                Row(
                    horizontalArrangement = Arrangement.spacedBy(10.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Card(
                        modifier = Modifier.size(100.dp),
                        shape = RoundedCornerShape(28.dp),
                        colors = CardDefaults.cardColors(
                            containerColor = Color.Red
                        ),
                        elevation = CardDefaults.cardElevation(30.dp)
                    ) {
                        Box(Modifier.fillMaxSize()) {
                            Icon(
                                imageVector = Icons.Default.Delete,
                                contentDescription = "Delete Icon",
                                tint = Color.White,
                                modifier = Modifier.size(56.dp).align(Alignment.Center)
                            )
                        }
                    }
                    Text(
                        text = "Borrar",
                        color = Color.Red,
                        style = MaterialTheme.typography.headlineLarge,
                        textAlign = TextAlign.Center,
                        fontWeight = FontWeight.ExtraBold
                    )
                }
            },
            text = {
                Text(
                    text = message,
                    style = MaterialTheme.typography.bodyMedium,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(horizontal = 12.dp)
                )
            },
            dismissButton = {
                OutlinedButton(
                    onClick = onDismiss,
                    modifier = Modifier.height(50.dp)
                ) {
                    Text(text = "Cancelar", fontSize = 16.sp)
                }
            },
            shape = RoundedCornerShape(20.dp),
            containerColor = MaterialTheme.colorScheme.surface
        )
    }
}