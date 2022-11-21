package com.sample.grid.vertical

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.runtime.*
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

    val items = remember {
        mutableStateOf(getItems())
    }
    val selectedItems: MutableState<List<GridItem>> = remember {
        mutableStateOf(emptyList())
    }
    val shownItems = remember(selectedItems.value) {

        derivedStateOf {
            println("debug_derived: Here")
            val result = mutableListOf<GridItem>()
            for (item in items.value) {
                val index = getIndex(item, selectedItems.value)
                result.add(item.copy(index = index + 1, selected = index != -1))
            }
            result.toList()
        }
    }

    LazyVerticalGrid(
        modifier = Modifier.fillMaxSize(),
        columns = GridCells.Fixed(3),
        horizontalArrangement = Arrangement.spacedBy(spacing),
        verticalArrangement = Arrangement.spacedBy(spacing),
        contentPadding = PaddingValues(spacing),
        content = {
            itemsIndexed(shownItems.value) { index, item ->
                VGridItem(
                    color = getColor(index + 1),
                    gridItem = item,
                    onItemClick = {
                        if (item.selected) {
                            selectedItems.value = selectedItems.value.deleteItem { it.id == item.id }
                        } else {
                            selectedItems.value = selectedItems.value.addItemAtEnd(item)
                        }
                    }
                )
            }
            /*item(span = { GridItemSpan(maxCurrentLineSpan) }) {
                VGridItem(color = Color.Yellow)
            }*/
        }
    )
}

private fun getIndex(item: GridItem, items: List<GridItem>): Int {
    return items.indexOfFirst { it.id == item.id }
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

private fun getItems(): List<GridItem> {
    return listOf(
        GridItem(index = 0, selected = false, id = 1L),
        GridItem(index = 0, selected = false, id = 2L),
        GridItem(index = 0, selected = false, id = 3L),
        GridItem(index = 0, selected = false, id = 4L),
        GridItem(index = 0, selected = false, id = 5L),
    )
}