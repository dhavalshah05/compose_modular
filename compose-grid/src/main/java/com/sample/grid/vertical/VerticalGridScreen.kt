package com.sample.grid.vertical

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.GridItemSpan
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview
@Composable
private fun PreviewVerticalGridScreen() {
    VerticalGridScreen()
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
internal fun VerticalGridScreen(
    modifier: Modifier = Modifier
) {
    val spacing = 30.dp

    LazyVerticalGrid(
        modifier = Modifier.fillMaxSize(),
        cells = GridCells.Fixed(3),
        horizontalArrangement = Arrangement.spacedBy(spacing),
        verticalArrangement = Arrangement.spacedBy(spacing),
        contentPadding = PaddingValues(spacing),
        content = {
            items(40) { index ->
                VGridItem(color = getColor(index + 1))
            }
            /*item(span = { GridItemSpan(maxCurrentLineSpan) }) {
                VGridItem(color = Color.Yellow)
            }*/
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