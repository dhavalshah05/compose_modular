package com.sample.androidview

import android.content.Context
import android.view.View
import android.widget.Button
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.platform.ViewCompositionStrategy
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.viewinterop.AndroidView

class ComposeAndroidView(
    private val context: Context
) {
    fun getRootView(): View {
        return ComposeView(context).apply {
            setViewCompositionStrategy(ViewCompositionStrategy.DisposeOnViewTreeLifecycleDestroyed)
            setContent {
                ComposeAndroidScreen()
            }
        }
    }
}

@Preview
@Composable
private fun PreviewComposeAndroidView() {
    ComposeAndroidScreen()
}

@Composable
private fun ComposeAndroidScreen() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxSize()
        ) {
            val someState = remember {
                mutableStateOf(false)
            }

            Button(
                content = { Text(text = "Compose Button") },
                onClick = { someState.value = !someState.value }
            )
            AndroidView(
                factory = { context ->
                    // factory will be called only once while creating view.
                    // Once factory is called, it will call update immediately.
                    val button = Button(context)
                    button.text = "View Button"
                    button
                },
                update = { button ->
                    // update will be called multiple times. As we are reading compose state here.
                    button.text = if (someState.value) "View Button updated" else "View Button noraml"
                }
            )
        }
    }
}