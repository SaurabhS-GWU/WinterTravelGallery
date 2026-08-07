package com.example.wintertravelgallery.ui.DestinationsScreen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.wintertravelgallery.domain.DestinationModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DestinationsScreen(
    viewModel: DestinationViewModel = hiltViewModel()
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            TopAppBar(
                title = {
                    Text("Winter Travel Gallery")
                }
            )
        }
    ) { paddingValues ->
        when (val state = uiState) {
            DestinationsUiState.Loading -> {
                Text(
                    text = "Loading destinations...",
                    modifier = Modifier.padding(paddingValues)
                )
            }

            is DestinationsUiState.Success -> {
                DestinationsContent(
                    destinations = state.destinations,
                    modifier = Modifier.padding(paddingValues)
                )
            }

            is DestinationsUiState.Error -> {
                Text(
                    text = state.message,
                    modifier = Modifier.padding(paddingValues)
                )
            }
        }
    }
}

@Composable
private fun DestinationsContent(
    destinations: List<DestinationModel>,
    onDestinationClick: (DestinationModel) -> Unit = {},
    modifier: Modifier = Modifier
) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        modifier = modifier.fillMaxSize(),
        contentPadding = PaddingValues(16.dp),
        horizontalArrangement = Arrangement.spacedBy(12.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        items(
            items = destinations,
            key = { it.title }
        ) { destination ->
            DestinationGridItem(
                destination = destination,
                onClick = { onDestinationClick(destination) },
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}
