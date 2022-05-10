package com.example.composelibrary

import android.content.Context
import android.view.View
import androidx.compose.material.Text
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.platform.ViewCompositionStrategy

class TempView(
    private val context: Context
) {
    fun getRootView(): View {
        return ComposeView(context).apply {
            setViewCompositionStrategy(ViewCompositionStrategy.DisposeOnViewTreeLifecycleDestroyed)
            setContent {
                Text(
                    text = "Hello There From Compose",
                    color = Color.Red
                )
            }
        }
    }
}