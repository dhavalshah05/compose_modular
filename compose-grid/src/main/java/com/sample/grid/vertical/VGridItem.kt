package com.sample.grid.vertical

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview
@Composable
private fun PreviewVGridItem() {
    VGridItem(color = Color.Yellow)
}

@Composable
internal fun VGridItem(
    modifier: Modifier = Modifier,
    color: Color
) {
    Box(
        modifier = modifier.fillMaxWidth()
            .heightIn(min = 100.dp)
            .background(color),
    ) {
    }
}