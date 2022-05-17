package com.example.composetheme

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

@Immutable
internal data class CustomColors(
    val screenBackground: Color,
    val buttonBackground: Color,
    val buttonText: Color
)

internal val LocalCustomColors = staticCompositionLocalOf {
    CustomColors(
        screenBackground = Color.Unspecified,
        buttonBackground = Color.Unspecified,
        buttonText = Color.Unspecified
    )
}

@Composable
internal fun CustomTheme(
    isDarkTheme: Boolean = false,
    content: @Composable () -> Unit
) {
    val customColors = if (isDarkTheme) {
        CustomColors(
            screenBackground = Color.Black,
            buttonBackground = Color.White,
            buttonText = Color.Black
        )
    } else {
        CustomColors(
            screenBackground = Color.White,
            buttonBackground = Color.Black,
            buttonText = Color.White
        )
    }

    CompositionLocalProvider(
        values = arrayOf(LocalCustomColors provides customColors),
        content = content
    )
}