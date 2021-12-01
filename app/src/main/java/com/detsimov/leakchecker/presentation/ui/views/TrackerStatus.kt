package com.detsimov.leakchecker.presentation.ui.views

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowRight
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.content.ContextCompat
import coil.compose.rememberImagePainter
import com.detsimov.leakchecker.R
import com.detsimov.leakchecker.domain.models.TrackerDataType
import com.detsimov.leakchecker.domain.models.TrackerStatusModel
import com.detsimov.leakchecker.presentation.ui.theme.LeakCheckerTheme
import com.detsimov.leakchecker.presentation.ui.theme.highlight

@Preview(backgroundColor = 0xFFFFFF)
@Composable
private fun TrackerStatus_Preview() {
    LeakCheckerTheme {
        TrackerStatus(
            Modifier.width(200.dp),
            model = TrackerStatusModel("test@mail.ru", TrackerDataType.EMAIL, 888, 22)
        )
    }
}

@Composable
fun TrackerStatus(modifier: Modifier = Modifier, model: TrackerStatusModel) {
    Box(modifier = modifier) {
        Row(
            modifier = Modifier.padding(vertical = 4.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                modifier = Modifier.size(48.dp),
                painter = rememberImagePainter(
                    data = ContextCompat.getDrawable(
                        LocalContext.current,
                        R.drawable.ic_baseline_email
                    )
                ),
                contentDescription = null
            )
            Spacer(modifier = Modifier.size(8.dp))
            Column {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Column(
                        Modifier
                            .fillMaxWidth()
                            .weight(1f)
                    ) {
                        Text(
                            modifier = Modifier.fillMaxWidth(),
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis,
                            text = model.data,
                            style = MaterialTheme.typography.subtitle1.copy(fontWeight = FontWeight.Medium)
                        )
                        Text(
                            modifier = Modifier.fillMaxWidth(),
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis,
                            text = "Breach detected: ${model.breachesCount}",
                            style = MaterialTheme.typography.body2,
                            color = MaterialTheme.colors.highlight
                        )
                    }
                    if (model.newBreachesCount > 0) {
                        CountNotification(count = model.newBreachesCount)
                    }
                    Icon(
                        modifier = Modifier.size(36.dp),
                        imageVector = Icons.Filled.ArrowRight,
                        contentDescription = null
                    )
                }
                Spacer(modifier = Modifier.padding(top = 4.dp))
                Divider()
            }
        }
    }
}