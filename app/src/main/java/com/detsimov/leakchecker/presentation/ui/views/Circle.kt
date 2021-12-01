package com.detsimov.leakchecker.presentation.ui.views

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview
@Composable
private fun Circle_Preview() {
    Circle(modifier = Modifier.size(100.dp), Color.Red)
}

@Composable
fun Circle(
    modifier: Modifier = Modifier,
    colorCircle: Color,
    content: @Composable BoxScope.() -> Unit = {}
) {
    Box {
        Canvas(modifier = modifier) { drawCircle(colorCircle) }
        content()
    }
}