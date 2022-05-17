package com.example.composetheme

import android.content.Context
import android.view.View
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.platform.ViewCompositionStrategy

class LightDarkView(
    private val context: Context
) {
    fun getRootView(): View {
        return ComposeView(context).apply {
            setViewCompositionStrategy(ViewCompositionStrategy.DisposeOnViewTreeLifecycleDestroyed)
            setContent {
                val isDarkThemeState = remember {
                    mutableStateOf(false)
                }
                CustomTheme(isDarkTheme = isDarkThemeState.value) {
                    LightDarkScreen(
                        onThemeChange = {
                            isDarkThemeState.value = isDarkThemeState.value.not()
                        }
                    )
                }
            }
        }
    }
}