package com.kevinduran.duran_ui_kit.shared.listitem

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun DuranLargeListItemImage(
    image: Painter,
    modifier: Modifier = Modifier,
    size: Dp = 60.dp,
    contentDescription: String? = null
) {
    Image(
        painter = image,
        contentDescription = contentDescription,
        modifier = modifier.size(size)
    )
}