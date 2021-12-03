package com.detsimov.leakchecker.presentation.ui.views

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp

@Composable
fun Margin(vertical: Dp = Dp.Hairline, horizontal: Dp = Dp.Hairline) {
    Spacer(modifier = Modifier.padding(vertical = vertical, horizontal = horizontal))
}