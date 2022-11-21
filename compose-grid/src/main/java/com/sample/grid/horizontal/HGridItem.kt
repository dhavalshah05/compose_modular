package com.sample.grid.horizontal

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview
@Composable
private fun PreviewHGridItem() {
    HGridItem(color = Color.Yellow)
}

@Composable
internal fun HGridItem(
    modifier: Modifier = Modifier,
    color: Color
) {
    Box(
        modifier = modifier.fillMaxHeight()
            .widthIn(min = 140.dp)
            .background(color),
    ) {
    }
}