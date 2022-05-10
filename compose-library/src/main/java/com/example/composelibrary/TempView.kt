package com.example.composelibrary

import android.content.Context
import android.view.View
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.layout.positionInRoot
import androidx.compose.ui.layout.positionInWindow
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.platform.ViewCompositionStrategy
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class TempView(
    private val context: Context
) {
    fun getRootView(): View {
        return ComposeView(context).apply {
            setViewCompositionStrategy(ViewCompositionStrategy.DisposeOnViewTreeLifecycleDestroyed)
            setContent {

                val width = remember { mutableStateOf(IntSize.Zero) }

                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(color = Color.Gray.copy(alpha = 0.7F))
                        .padding(30.dp)
                        .background(color = Color.Gray),
                    contentAlignment = Alignment.Center,
                ) {
                    Text(
                        text = "Hello There width = ${width.value.toString()}",
                        color = Color.Red,
                        fontSize = 16.sp,
                        modifier = Modifier.background(color = Color.Yellow).onGloballyPositioned {
                            width.value = it.size
                            println("Size Height = ${it.size.height}")
                            println("Size Width = ${it.size.width}")
                            println("Position Window = ${it.positionInWindow().x}, ${it.positionInWindow().y}")
                            println("Position Root = ${it.positionInRoot().x}, ${it.positionInRoot().y}")
                            println("Position Window = ${it.positionInWindow().x}, ${it.positionInWindow().y}")
                        }
                    )
                }
            }
        }
    }
}