package com.example.composetheme

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Preview
@Composable
private fun PreviewLightDarkScreen() {
    CustomTheme(isDarkTheme = false) {
        LightDarkScreen {}
    }
}

@Composable
internal fun LightDarkScreen(
    modifier: Modifier = Modifier,
    onThemeChange: () -> Unit,
) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .background(LocalCustomColors.current.screenBackground),
        contentAlignment = Alignment.Center
    ) {
        Button(
            onClick = onThemeChange,
            content = {
                Text(
                    text = "Click to change theme",
                    color = LocalCustomColors.current.buttonText
                )
            },
            colors = ButtonDefaults.buttonColors(
                backgroundColor = LocalCustomColors.current.buttonBackground
            )
        )
    }
}