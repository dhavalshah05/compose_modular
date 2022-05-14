package com.example.composelibrary.dynamicsize

import android.content.Context
import android.view.View
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.layout.positionInRoot
import androidx.compose.ui.layout.positionInWindow
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.platform.ViewCompositionStrategy
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.delay

class TempView(
    private val context: Context
) {
    fun getRootView(): View {
        return ComposeView(context).apply {
            setViewCompositionStrategy(ViewCompositionStrategy.DisposeOnViewTreeLifecycleDestroyed)
            setContent {
                val someValue = remember { mutableStateOf(true) }
                TempView(someValue = someValue.value) {
                    someValue.value = !someValue.value
                }
            }
        }
    }
}

@Composable
private fun TempView(
    someValue: Boolean,
    onButtonClick: () -> Unit
) {

    val width = remember { mutableStateOf(IntSize.Zero) }

    SideEffect {
        println("Side Effect ${someValue} = ${System.currentTimeMillis()}")
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.Gray.copy(alpha = 0.5F))
            .padding(30.dp)
            .background(color = Color.Gray),
        contentAlignment = Alignment.Center,
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Hello There width = ${width.value.toString()}",
                color = Color.Red,
                fontSize = 16.sp,
                modifier = Modifier
                    .background(color = Color.Yellow)
                    .onGloballyPositioned {
                        width.value = it.size
                        println("Size Height = ${it.size.height}")
                        println("Size Width = ${it.size.width}")
                        println("Position Window = ${it.positionInWindow().x}, ${it.positionInWindow().y}")
                        println("Position Root = ${it.positionInRoot().x}, ${it.positionInRoot().y}")
                        println("Position Window = ${it.positionInWindow().x}, ${it.positionInWindow().y}")
                    }
            )
            Button(onClick = onButtonClick) {
                Text(text = "Click Me")
            }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
private fun TempViewPreview() {
    TempView(someValue = false) {}
}