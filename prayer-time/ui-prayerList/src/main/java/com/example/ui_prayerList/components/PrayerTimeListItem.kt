package com.example.ui_prayerList.components

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

@Composable
fun DisplayPrayerTime(
    name: String, time: String,
    onClickPrayer: () -> Unit = {},
) {
    Text(
        text = "$name: ${time.substringBefore(" ")}",
        style = MaterialTheme.typography.headlineMedium,
        color = Color.Black
    )
}