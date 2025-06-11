package com.kevinduran.duran_ui_kit.pages

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.rounded.KeyboardArrowRight
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

@Composable
fun DuranWelcomePage(
    title: String,
    subtitle: String,
    modifier: Modifier = Modifier,
    image: Painter,
    primaryButtonText: String = "Primary",
    secondaryButtonText: String = "Secondary",
    showPrimaryButton: Boolean = true,
    showSecondaryButton: Boolean = true,
    onPrimaryButtonClick: () -> Unit = {},
    onSecondaryButtonClick: () -> Unit = {}

) {
    Box(modifier = modifier.fillMaxSize()) {
        val canvasColor = MaterialTheme.colorScheme.primary
        val canvasContentColor = MaterialTheme.colorScheme.surface
        val canvasSize = remember { mutableFloatStateOf(0f) }

        Column(
            modifier = Modifier
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {

            Box(Modifier.weight(1f)) {
                Image(
                    painter = image,
                    contentDescription = null,
                    modifier = Modifier.fillMaxSize(),
                    contentScale = ContentScale.FillHeight
                )
            }

            Box(Modifier.weight(2f).fillMaxWidth()) {
                Canvas(
                    modifier = Modifier
                        .fillMaxSize()
                        .align(Alignment.BottomCenter)
                ) {
                    canvasSize.floatValue = size.height
                    val path = Path().apply {
                        moveTo(0f, size.height)
                        lineTo(0f, size.height * 0.4f)

                        quadraticTo(
                            size.width * 0f, size.height * 0.2f,
                            size.width * 0.3f, size.height * 0.2f
                        )

                        quadraticTo(
                            size.width * 0.6f, size.height * 0.2f,
                            size.width * 0.7f, size.height * 0.2f
                        )

                        quadraticTo(
                            size.width * 0.99f, size.height * 0.2f,
                            size.width, size.height * 0f
                        )

                        lineTo(size.width, size.height)
                        close()
                    }

                    drawPath(
                        path = path,
                        color = canvasColor
                    )
                }
                Column(
                    Modifier.fillMaxSize().padding(horizontal = 16.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                ) {
                    Spacer(Modifier.height((canvasSize.floatValue * 0.1).dp))
                    Text(
                        text = title,
                        style = MaterialTheme.typography.headlineLarge.copy(
                            fontWeight = FontWeight.Bold,
                            color = canvasContentColor
                        ),
                        textAlign = TextAlign.Center
                    )

                    Spacer(modifier = Modifier.height(8.dp))

                    Text(
                        text = subtitle,
                        style = MaterialTheme.typography.bodyLarge,
                        color = canvasContentColor.copy(alpha = 0.8f),
                        textAlign = TextAlign.Center,
                    )

                    Spacer(modifier = Modifier.weight(1f))

                    AnimatedVisibility(showPrimaryButton) {
                        Button(
                            onClick = onPrimaryButtonClick,
                            modifier = Modifier.fillMaxWidth().height(60.dp),
                            colors = ButtonDefaults.buttonColors(
                                containerColor = MaterialTheme.colorScheme.surface,
                                contentColor = MaterialTheme.colorScheme.onSurface
                            )
                        ) {
                            Text(text = primaryButtonText)
                        }
                    }

                    AnimatedVisibility(showSecondaryButton) {
                        Spacer(modifier = Modifier.height(16.dp))
                    }

                    AnimatedVisibility(showSecondaryButton) {
                        Button(
                            onClick = onSecondaryButtonClick,
                            modifier = Modifier.fillMaxWidth().height(60.dp),
                            colors = ButtonDefaults.buttonColors(
                                containerColor = MaterialTheme.colorScheme.surface,
                                contentColor = MaterialTheme.colorScheme.onSurface
                            )
                        ) {
                            Box(Modifier.fillMaxSize()) {
                                Text(text = secondaryButtonText, modifier = Modifier.align(Alignment.Center))
                                Icon(Icons.AutoMirrored.Rounded.KeyboardArrowRight, "icon", modifier = Modifier.align(Alignment.CenterEnd))
                            }
                        }
                    }
                    Spacer(modifier = Modifier.navigationBarsPadding())
                }
            }

        }
    }
}
