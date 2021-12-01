package com.detsimov.leakchecker.presentation.ui.views

import androidx.compose.foundation.layout.size
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.contentColorFor
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.detsimov.leakchecker.presentation.ui.theme.warning

@Composable
@Preview
fun CountNotification_Preview() {
    CountNotification(55)
}

@Composable
fun CountNotification(count: Int) {
    val countText by remember(count) { derivedStateOf { count.toString() } }
    val circleColor = MaterialTheme.colors.warning
    Circle(modifier = Modifier.size(30.dp), colorCircle = circleColor) {
        Text(
            modifier = Modifier.align(Alignment.Center),
            text = countText,
            style = MaterialTheme.typography.caption,
            color = contentColorFor(backgroundColor = circleColor)
        )
    }
}