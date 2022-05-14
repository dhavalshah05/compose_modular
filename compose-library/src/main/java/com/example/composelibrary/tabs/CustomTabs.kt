package com.example.composelibrary.tabs

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.TabRowDefaults.tabIndicatorOffset
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex

@Preview
@Composable
private fun CustomTabsPreview() {
    CustomTabs()
}

@Composable
fun CustomTabs() {
    val selectedTabIndex = remember {
        mutableStateOf(0)
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black),
        contentAlignment = Alignment.Center
    ) {
        ScrollableTabRow(
            modifier = Modifier.wrapContentWidth(),
            selectedTabIndex = selectedTabIndex.value,
            contentColor = Color.Red.copy(alpha = 0.5f),
            edgePadding = 0.dp,
            tabs = {
                for (i in 0..10) {
                    Tab(
                        selected = i == selectedTabIndex.value,
                        onClick = { selectedTabIndex.value = i },
                        selectedContentColor = Color.Cyan,
                        unselectedContentColor = Color.White,
                    ) {
                        Text("Tab Item", modifier = Modifier.padding(vertical = 12.dp))
                    }
                }
            },
            indicator = { tabPositions ->
                val tabPosition = tabPositions[selectedTabIndex.value]
                TabRowDefaults.Indicator(
                    Modifier
                        .tabIndicatorOffset(tabPosition)
                        .zIndex(-1f)
                        .padding(vertical = 4.dp, horizontal = 2.dp)
                        .clip(RoundedCornerShape(100.dp))
                        .fillMaxHeight(),
                )
            },
            divider = {

            }
        )
    }
}