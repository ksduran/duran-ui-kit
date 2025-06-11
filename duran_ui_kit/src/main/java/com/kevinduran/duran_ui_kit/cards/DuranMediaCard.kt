package com.kevinduran.duran_ui_kit.cards

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.Alignment

@Composable
fun DuranMediaCard(
    image: Painter,
    modifier: Modifier = Modifier,
    contentDescription: String? = null,
    title: String? = null,
    subtitle: String? = null,
    imageSize: Dp = 160.dp,
    elevation: Dp? = null
) {
    Card(
        modifier = modifier,
        elevation = CardDefaults.cardElevation(defaultElevation = elevation ?: 0.dp),
        shape = MaterialTheme.shapes.medium
    ) {
        Column(
            modifier = Modifier.width(imageSize),
            horizontalAlignment = Alignment.Start
        ) {
            Image(
                painter = image,
                contentDescription = contentDescription,
                modifier = Modifier
                    .size(imageSize)
                    .fillMaxWidth()
            )

            if (!title.isNullOrBlank()) {
                Text(
                    text = title,
                    style = MaterialTheme.typography.bodyLarge,
                    modifier = Modifier
                        .padding(horizontal = 12.dp, vertical = 4.dp),
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
            }

            if (!subtitle.isNullOrBlank()) {
                Text(
                    text = subtitle,
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.outline,
                    modifier = Modifier
                        .padding(horizontal = 12.dp, vertical = 2.dp),
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
            }
        }
    }
}
