package com.detsimov.leakchecker.presentation.features.home.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.detsimov.leakchecker.R
import com.detsimov.leakchecker.domain.models.TrackerDataType
import com.detsimov.leakchecker.domain.models.TrackerStatusModel
import com.detsimov.leakchecker.presentation.features.home.mvi.HomeState
import com.detsimov.leakchecker.presentation.ui.theme.LeakCheckerTheme
import com.detsimov.leakchecker.presentation.ui.views.Counter
import com.detsimov.leakchecker.presentation.ui.views.TrackerStatus

@Preview
@Composable
fun HomeContent_Preview() {
    LeakCheckerTheme { HomeContent(HomeState()) }
}

@Composable
fun HomeContent(state: HomeState) {
    Scaffold {
        Column(
            Modifier
                .fillMaxSize()
        ) {
            TopAppBar(
                title = {
                    Text(text = stringResource(id = R.string.home_title))
                },
                actions = {
                    IconButton(
                        onClick = {

                        }
                    ) {
                        Icon(imageVector = Icons.Filled.Add, contentDescription = null)
                    }
                }
            )
            Column(Modifier.padding(vertical = 12.dp)) {
                Card(
                    Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 8.dp), shape = MaterialTheme.shapes.large
                ) {
                    Column(Modifier.padding(16.dp)) {
                        Row {
                            Text(
                                text = "24/7 Monitoring",
                                style = MaterialTheme.typography.subtitle1.copy(
                                    fontWeight = FontWeight.Medium
                                )
                            )
                            Spacer(modifier = Modifier.weight(1f))
                            Row(
                                modifier = Modifier.padding(end = 2.dp),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Icon(
                                    modifier = Modifier.padding(horizontal = 4.dp),
                                    imageVector = Icons.Filled.Refresh,
                                    contentDescription = null,
                                    tint = MaterialTheme.colors.primaryVariant
                                )
                                Text(text = "Refresh", color = MaterialTheme.colors.primaryVariant)
                            }
                        }
                        Divider(Modifier.padding(vertical = 8.dp))
                        Row(Modifier.fillMaxWidth()) {
                            Counter(
                                modifier = Modifier.weight(1f),
                                value = state.breachesInfo.newBreaches,
                                title = "New breaches"
                            )
                            Spacer(modifier = Modifier.size(8.dp))
                            Counter(
                                modifier = Modifier.weight(1f),
                                value = state.breachesInfo.allBreaches,
                                title = "All breaches"
                            )
                        }
                    }
                }
                Text(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 16.dp, bottom = 8.dp, start = 10.dp),
                    text = "Trackers",
                    style = MaterialTheme.typography.h5,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
                LazyColumn(
                    Modifier
                        .fillMaxSize(),
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    items(state.trackers, key = { it.data }) {
                        Box(Modifier.clickable {

                        }) {
                            TrackerStatus(
                                model = it,
                                modifier = Modifier.padding(horizontal = 8.dp)
                            )
                        }
                    }
                }
            }
        }
    }
}