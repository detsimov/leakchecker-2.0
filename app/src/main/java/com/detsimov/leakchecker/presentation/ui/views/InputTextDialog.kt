package com.detsimov.leakchecker.presentation.ui.views

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import com.detsimov.leakchecker.presentation.ui.theme.LeakCheckerTheme

@Preview()
@Composable
private fun InputTextDialog_Preview() {
    LeakCheckerTheme {
        InputTextDialogContent(
            title = "Title title title",
            body = "Body body",
            onConfirmRequest = {},
            onDismissRequest = {}
        )
    }
}

@Composable
fun InputTextDialog(
    modifier: Modifier = Modifier,
    title: String,
    body: String,
    onConfirmRequest: (String) -> Unit,
    onDismissRequest: () -> Unit,
) {
    Dialog(onDismissRequest = onDismissRequest) {
        InputTextDialogContent(
            modifier,
            title,
            body,
            onConfirmRequest,
            onDismissRequest
        )
    }
}

@Composable
fun InputTextDialogContent(
    modifier: Modifier = Modifier,
    title: String,
    body: String,
    onConfirmRequest: (String) -> Unit,
    onDismissRequest: () -> Unit,
) {
    Surface(modifier = modifier, shape = MaterialTheme.shapes.medium) {
        Column(modifier = Modifier.padding(16.dp)) {
            var text by remember { mutableStateOf("") }
            Text(text = title, style = MaterialTheme.typography.subtitle1)
            Margin(vertical = 2.dp)
            Text(text = body, style = MaterialTheme.typography.body2)
            Margin(vertical = 4.dp)
            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                value = text,
                label = { Text(text = "Почта") },
                placeholder = { Text(text = "test@gmail.com") },
                onValueChange = { text = it },
                maxLines = 1
            )
            Margin(vertical = 4.dp)
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.End,
                verticalAlignment = Alignment.CenterVertically
            ) {
                val buttonsWidth = 100.dp
                Button(
                    modifier = Modifier.width(buttonsWidth),
                    onClick = onDismissRequest
                ) {
                    Text(text = "Отмена", maxLines = 1)
                }
                Margin(horizontal = 4.dp)
                Button(
                    modifier = Modifier.width(buttonsWidth),
                    onClick = {
                        if (text.isBlank()) {
                            onDismissRequest()
                        } else {
                            onConfirmRequest(text)
                        }
                    }
                ) {
                    Text(text = "Ок", maxLines = 1)
                }
            }
        }
    }
}