package com.example.composelibrary

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.sp

@Immutable
data class CustomColors(
    val textColor: Color
)

data class CustomTypography(
    val title: TextStyle,
    val body: TextStyle
)

val LocalCustomColors = staticCompositionLocalOf {
    CustomColors(
        textColor = Color.Unspecified
    )
}

val LocalCustomTypography = staticCompositionLocalOf {
    CustomTypography(
        title = TextStyle.Default,
        body = TextStyle.Default
    )
}

@Composable
fun CustomTheme(content: @Composable () -> Unit) {
    val customColors = CustomColors(
        textColor = Color.Green
    )
    val customTypography = CustomTypography(
        title = TextStyle.Default.copy(fontSize = 30.sp),
        body = TextStyle.Default.copy(fontSize = 14.sp)
    )

    CompositionLocalProvider(
        values = arrayOf(
            LocalCustomColors provides customColors,
            LocalCustomTypography provides customTypography
        ),
        content = content
    )
}