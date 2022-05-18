package com.sample.animation.infinite

import android.content.Context
import android.view.View
import androidx.compose.animation.animateColor
import androidx.compose.animation.core.*
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.platform.ViewCompositionStrategy
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

class InfiniteAnimationView(
    private val context: Context
) {

    fun getRootView(): View {
        return ComposeView(context).apply {
            setViewCompositionStrategy(ViewCompositionStrategy.DisposeOnViewTreeLifecycleDestroyed)
            setContent {
                InfiniteAnimationScreen()
            }
        }
    }
}

@Preview
@Composable
private fun PreviewInfiniteAnimationScreen() {
    InfiniteAnimationScreen()
}

@Composable
private fun InfiniteAnimationScreen() {

    val infiniteTransition = rememberInfiniteTransition()
    val color = infiniteTransition.animateColor(
        initialValue = Color.Black,
        targetValue = Color.Green,
        animationSpec = infiniteRepeatable(
            animation = tween(durationMillis = 2000, easing = LinearOutSlowInEasing),
            repeatMode = RepeatMode.Restart
        )
    )

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        contentAlignment = Alignment.Center,
    ) {

        Box(
            modifier = Modifier
                .size(100.dp)
                .background(color.value, CircleShape),
        ) {

        }

    }
}