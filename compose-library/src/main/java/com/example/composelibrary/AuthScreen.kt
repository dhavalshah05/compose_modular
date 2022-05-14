package com.example.composelibrary

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview
@Composable
private fun AuthScreenPreview() {
    AuthScreen()
}

@Composable
fun AuthScreen() {
    Box(
       modifier = Modifier.fillMaxSize()
           .background(Color.Gray.copy(alpha = 0.5f))
    ) {
        LazyColumn(
            contentPadding = PaddingValues(20.dp),
            verticalArrangement = Arrangement.spacedBy(20.dp),
            content = {
                items(10) {
                    AddShopTextField(
                        value = "",
                        onValueChange = {}
                    )
                }
            }
        )
    }
}