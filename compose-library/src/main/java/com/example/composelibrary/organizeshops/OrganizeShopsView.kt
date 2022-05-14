package com.example.composelibrary.organizeshops

import android.content.Context
import android.view.View
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.platform.ViewCompositionStrategy
import com.example.composelibrary.OrganizeShopsScreen

class OrganizeShopsView(
    private val context: Context
) {
    fun getRootView(): View {
        return ComposeView(context).apply {
            setViewCompositionStrategy(ViewCompositionStrategy.DisposeOnViewTreeLifecycleDestroyed)
            setContent {
                OrganizeShopsScreen()
            }
        }
    }
}