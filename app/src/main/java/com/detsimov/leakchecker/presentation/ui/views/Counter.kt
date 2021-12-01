package com.detsimov.leakchecker.presentation.ui.views

import androidx.compose.foundation.layout.Column
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.detsimov.leakchecker.presentation.ui.theme.highlight

@Composable
fun Counter(modifier: Modifier = Modifier, value: Int, title: String) {
    val valueText by remember(value) { derivedStateOf { if (value >= 1000) "999+" else value.toString() } }
    val isHighlight by remember(value) { derivedStateOf { value == 0 } }
    val textColor = if (isHighlight) MaterialTheme.colors.highlight else Color.Unspecified
    Column(modifier = modifier, horizontalAlignment = Alignment.CenterHorizontally) {
        Text(
            text = valueText,
            style = MaterialTheme.typography.h2,
            maxLines = 1,
            color = textColor
        )
        Text(
            text = title,
            style = MaterialTheme.typography.body2,
            maxLines = 2,
            color = textColor
        )
    }
}