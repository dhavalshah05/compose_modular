package com.example.composelibrary

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Preview
@Composable
fun OrganizeShopsScreenPreview() {
    OrganizeShopsScreen()
}

@Composable
fun OrganizeShopsScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
    ) {
        TopAppBar(
            modifier = Modifier
                .fillMaxWidth()
                .height(54.dp)
                .background(Color.White),
            backgroundColor = Color.White,
            elevation = 0.dp,
        ) {
            IconButton(onClick = {}, modifier = Modifier) {
                Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "")
            }
            Text(
                text = "Organize Shops",
                modifier = Modifier.weight(1f),
                textAlign = TextAlign.Center,
                color = Color.Black,
                fontSize = 18.sp
            )
            IconButton(onClick = {}, modifier = Modifier.alpha(0f)) {
                Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "")
            }
        }
        Box(
            modifier = Modifier.fillMaxSize(),
        ) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.DarkGray),
            )
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
                    .background(Color.White)
                    .align(Alignment.BottomCenter),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Spacer(modifier = Modifier.height(20.dp))
                Divider(
                    color = Color.Gray,
                    thickness = 4.dp,
                    modifier = Modifier
                        .width(40.dp)
                        .clip(RoundedCornerShape(4.dp))
                )
                Spacer(modifier = Modifier.height(20.dp))
                Text(
                    text = "Add Shop".uppercase(),
                    fontSize = 14.sp,
                    color = Color.Black,
                )
                Spacer(modifier = Modifier.height(20.dp))
                AddShopTextField(
                    value = "",
                    onValueChange = {},
                    modifier = Modifier.padding(horizontal = 10.dp)
                )
                Spacer(modifier = Modifier.height(20.dp))
            }
        }
    }
}