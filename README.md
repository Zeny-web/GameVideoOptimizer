package com.gamevideo.optimizer.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val GameColors = darkColorScheme(
    background = Color(0xFF0B1220),
    surface = Color(0xFF101A2F),
    primary = Color(0xFF5BFF8A),
    secondary = Color(0xFF6AA9FF),
    tertiary = Color(0xFF9DA9FF),
    onPrimary = Color.Black,
    onSecondary = Color.White,
    onBackground = Color(0xFFF5F7FF),
    onSurface = Color(0xFFF5F7FF),
)

@Composable
fun GameVideoOptimizerTheme(content: @Composable () -> Unit) {
    MaterialTheme(
        colorScheme = GameColors,
        content = content
    )
}
