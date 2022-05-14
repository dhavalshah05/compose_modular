package com.example.composelibrary.tabs

import android.content.Context
import android.view.View
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.platform.ViewCompositionStrategy

class TabView(
    private val context: Context
) {
    fun getRootView(): View {
        return ComposeView(context).apply {
            setViewCompositionStrategy(ViewCompositionStrategy.DisposeOnViewTreeLifecycleDestroyed)
            setContent {
                CustomTabs()
            }
        }
    }

}