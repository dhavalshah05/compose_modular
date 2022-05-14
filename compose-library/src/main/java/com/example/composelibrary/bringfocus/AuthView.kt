package com.example.composelibrary.bringfocus

import android.content.Context
import android.view.View
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.platform.ViewCompositionStrategy
import com.example.composelibrary.AuthScreen

class AuthView(
    private val context: Context
) {
    fun getRootView(): View {
        return ComposeView(context).apply {
            setViewCompositionStrategy(ViewCompositionStrategy.DisposeOnViewTreeLifecycleDestroyed)
            setContent {
                AuthScreen()
            }
        }
    }

}