package com.sample.pagination

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Preview
@Composable
private fun PreviewPaginatedList() {
    PaginatedList(items = emptyList(), onLoadMore = {})
}

@Composable
private fun rememberPaginatedLazyListState(
    itemsCount: Int,
    onLoadMore: (page: Int) -> Unit,
): LazyListState {
    val onLoadMoreLatest = rememberUpdatedState(newValue = onLoadMore)
    val state = rememberLazyListState()

    // region States for loading more data
    val loadingState = remember {
        mutableStateOf(false)
    }
    val previousItemsCountState = remember {
        mutableStateOf(0)
    }
    val page = remember {
        mutableStateOf(1)
    }
    // endregion States for loading more data

    if (itemsCount != 0) {
        LaunchedEffect(
            key1 = state.firstVisibleItemIndex,
            block = {
                val totalItemsCount = state.layoutInfo.totalItemsCount
                val lastVisibleItemPosition = state.layoutInfo.visibleItemsInfo.last().index

                if (loadingState.value && totalItemsCount > previousItemsCountState.value) {
                    loadingState.value = false
                    previousItemsCountState.value = totalItemsCount
                }

                if (!loadingState.value && lastVisibleItemPosition + 5 > totalItemsCount) {
                    val nextPage = page.value.plus(1)
                    page.value = nextPage
                    onLoadMoreLatest.value.invoke(nextPage)
                    loadingState.value = true
                    previousItemsCountState.value = totalItemsCount
                }
            }
        )
    } else {
        LaunchedEffect(
            key1 = Unit,
            block = {
                loadingState.value = false
                previousItemsCountState.value = 0
                page.value = 1
                onLoadMoreLatest.value.invoke(page.value)
            }
        )
    }

    return state
}

@Composable
internal fun PaginatedList(
    items: List<Int>,
    onLoadMore: (page: Int) -> Unit
) {
    
    val state = rememberPaginatedLazyListState(itemsCount = items.size, onLoadMore = onLoadMore)
    
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        state = state
    ) {
        items(items = items) {
            ListItem(it)
        }
    }
}

@Composable
private fun ListItem(id: Int, modifier: Modifier = Modifier) {
    val backgroundColor = if (id % 2 == 0) Color.White else Color.Gray.copy(alpha = 0.3F)
    Text(
        text = "Item $id",
        fontSize = 18.sp,
        color = Color.Black,
        modifier = modifier
            .fillMaxWidth()
            .background(backgroundColor)
            .padding(horizontal = 20.dp, vertical = 30.dp),
    )
}

/*
Key = ${state.layoutInfo.visibleItemsInfo.last().key}
Index = ${state.layoutInfo.visibleItemsInfo.last().index}
Size = ${state.layoutInfo.visibleItemsInfo.last().size}
Offset = ${state.layoutInfo.visibleItemsInfo.last().offset}
*/
