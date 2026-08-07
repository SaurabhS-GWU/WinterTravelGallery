package com.example.wintertravelgallery.ui.DestinationsScreen

import com.example.wintertravelgallery.domain.DestinationModel

sealed interface DestinationsUiState {
    data object Loading : DestinationsUiState

    data class Success(
        val destinations: List<DestinationModel>
    ) : DestinationsUiState

    data class Error(
        val message: String
    ) : DestinationsUiState
}
