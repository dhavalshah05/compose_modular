package com.sample.animation.finitesinglevalue

import android.content.Context
import android.view.View
import androidx.compose.animation.animateColor
import androidx.compose.animation.core.*
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.platform.ViewCompositionStrategy
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

class FiniteSingleValueAnimationView(
    private val context: Context
) {

    fun getRootView(): View {
        return ComposeView(context).apply {
            setViewCompositionStrategy(ViewCompositionStrategy.DisposeOnViewTreeLifecycleDestroyed)
            setContent {
                FiniteSingleValueAnimationScreen()
            }
        }
    }
}

@Preview
@Composable
private fun PreviewFiniteSingleValueAnimationScreen() {
    FiniteSingleValueAnimationScreen()
}

@Composable
private fun FiniteSingleValueAnimationScreen() {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {

        val startAnimation = remember {
            mutableStateOf(false)
        }
        val alpha = animateFloatAsState(if (startAnimation.value) 1f else 0.2f, animationSpec = tween(durationMillis = 300))

        Button(
            onClick = { startAnimation.value = !startAnimation.value },
        ) {
            Text("Click to animate alpha")
        }

        Box(
            modifier = Modifier
                .size(100.dp)
                .alpha(alpha = alpha.value)
                .background(Color.Black),
        ) {

        }

    }
}