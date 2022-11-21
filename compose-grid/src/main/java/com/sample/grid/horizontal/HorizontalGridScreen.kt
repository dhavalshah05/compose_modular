package com.sample.grid.horizontal

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview
@Composable
private fun PreviewHorizontalGridScreen() {
    HorizontalGridScreen()
}

@Composable
internal fun HorizontalGridScreen(
    modifier: Modifier = Modifier
) {
    val spacing = 30.dp

    LazyHorizontalGrid(
        modifier = Modifier.fillMaxSize(),
        rows = GridCells.Fixed(4),
        horizontalArrangement = Arrangement.spacedBy(spacing),
        verticalArrangement = Arrangement.spacedBy(spacing),
        contentPadding = PaddingValues(spacing),
        content = {
            items(13) { index ->
                HGridItem(color = getColor(index + 1))
            }
            item(span = { GridItemSpan(2) }) {
                HGridItem(color = Color.Yellow)
            }
        }
    )
}

private fun getColor(index: Int): Color {
    return when (index % 5) {
        4 -> Color.Red.copy(alpha = 0.65F)
        3 -> Color.Red.copy(alpha = 0.55F)
        2 -> Color.Red.copy(alpha = 0.4F)
        1 -> Color.Red.copy(alpha = 0.2F)
        else -> Color.Red.copy(alpha = 1F)
    }
}