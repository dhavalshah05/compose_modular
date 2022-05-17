package com.sample.pagination

import android.content.Context
import android.os.Handler
import android.view.View
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.platform.ViewCompositionStrategy
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class PaginatedListView(
    private val context: Context
) {

    private val items = mutableStateOf(getData())

    fun getRootView(): View {
        return ComposeView(context).apply {
            setViewCompositionStrategy(ViewCompositionStrategy.DisposeOnViewTreeLifecycleDestroyed)
            setContent {
                PaginatedList(
                    items = items.value,
                    onLoadMore = {
                        loadMore()
                    }
                )
            }
        }
    }

    private fun loadMore() {
        GlobalScope.launch {
            delay(2000)
            val newItems = mutableListOf<Int>()
            newItems.addAll(getData())
            newItems.addAll(getData())
            items.value = newItems.toList()
        }
    }

    private fun getData(): List<Int> {
        val items = mutableListOf<Int>()
        for (i in 1..30) {
            items.add(i)
        }
        return items
    }
}