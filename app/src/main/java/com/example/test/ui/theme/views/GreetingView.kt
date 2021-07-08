package com.example.test.ui.theme.views

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.ExperimentalUnitApi
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp

@ExperimentalUnitApi
@Composable
fun GreetingView() {
    Card(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth(), elevation = 3.dp,
    ) {
        Column(modifier = Modifier.padding(8.dp)) {
            Text(
                "Hello Tester",
                style = TextStyle(
                    fontSize = TextUnit(32f, type = TextUnitType.Sp),
                    fontWeight = FontWeight.Bold,
                )
            )
            Text("Welcome to the compose testing app", color = Color.DarkGray)
        }
    }
}

@ExperimentalUnitApi
@Preview
@Composable
fun GreetingViewPreview() {
    GreetingView()
}