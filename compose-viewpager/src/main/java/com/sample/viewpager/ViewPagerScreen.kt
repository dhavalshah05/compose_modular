package com.sample.viewpager

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager

@Preview
@Composable
private fun PreviewViewPagerScreen() {
    ViewPagerScreen()
}

@OptIn(ExperimentalPagerApi::class)
@Composable
internal fun ViewPagerScreen(
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .background(Color.White),
        contentAlignment = Alignment.Center
    ) {
      HorizontalPager(
          count = 10,
          modifier = Modifier.background(Color.Red),
          key = { it }
      ) { index ->

          Column(
              modifier = Modifier
                  .fillMaxWidth()
                  .background(Color.Yellow, shape = RoundedCornerShape(15.dp)),
              horizontalAlignment = Alignment.CenterHorizontally,
              verticalArrangement = Arrangement.Center
          ) {

              val boxColor = remember { mutableStateOf(Color.Green) }

              DisposableEffect(key1 = index) {
                  println("debug_pager: Effect started for id = $index")
                  onDispose {
                      println("debug_pager: Effect disposed for id = $index")
                  }
              }

              Box(modifier = Modifier
                  .size(100.dp)
                  .background(boxColor.value)
                  .clickable { boxColor.value = Color.Black })
              Text(text = "Page $index")
          }
      }
    }
}