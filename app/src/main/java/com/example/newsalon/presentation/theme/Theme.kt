package com.example.newsalon.presentation.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

@Composable
fun BeautyAppTheme(content: @Composable () -> Unit) {
    val colorScheme = lightColorScheme(
        primary = BeautyRed,
        onPrimary = BeautyWhite,
        secondary = BeautyLightRed,
        // ✅ جعل الخلفية والأسطح باللون الأبيض لجميع الواجهات
        background = Color.White,
        surface = Color.White,
        onBackground = BeautyDarkGray,
        onSurface = BeautyDarkGray,
    )
    
    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}
