package com.sample.animation.finitemultiplevalues

import android.content.Context
import android.view.View
import androidx.compose.animation.animateColor
import androidx.compose.animation.core.*
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.platform.ViewCompositionStrategy
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

class FiniteMultipleValuesAnimationView(
    private val context: Context
) {

    fun getRootView(): View {
        return ComposeView(context).apply {
            setViewCompositionStrategy(ViewCompositionStrategy.DisposeOnViewTreeLifecycleDestroyed)
            setContent {
                FiniteMultipleValuesAnimationScreen()
            }
        }
    }
}

@Preview
@Composable
private fun PreviewFiniteMultipleValuesAnimationScreen() {
    FiniteMultipleValuesAnimationScreen()
}

@Composable
private fun FiniteMultipleValuesAnimationScreen() {

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

        val updateTransition = updateTransition(
            targetState = startAnimation.value,
            label = "Box update transition",
        )

        val alpha = updateTransition.animateFloat(label = "animating alpha") { isAnimationStarted ->
            if (isAnimationStarted) 1f else 0.2f
        }

        val color = updateTransition.animateColor(label = "animating color") { isAnimationStarted ->
            if (isAnimationStarted) Color.Black else Color.Red
        }

        val size = updateTransition.animateDp(label = "animating size") { isAnimationStarted ->
            if (isAnimationStarted) 200.dp else 100.dp
        }

        Button(
            onClick = { startAnimation.value = !startAnimation.value },
        ) {
            Text("Click to animate multiple values")
        }

        Box(
            modifier = Modifier
                .size(size = size.value)
                .alpha(alpha = alpha.value)
                .background(color = color.value),
        ) {

        }

    }
}