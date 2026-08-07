package com.example.wintertravelgallery.ui.DestinationsScreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.wintertravelgallery.domain.GetDestinationUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

@HiltViewModel
class DestinationViewModel @Inject constructor(
    private val getDestinationUseCase: GetDestinationUseCase
) : ViewModel() {

    private val _uiState = MutableStateFlow<DestinationsUiState>(DestinationsUiState.Loading)
    val uiState: StateFlow<DestinationsUiState> = _uiState.asStateFlow()

    init {
        loadDestinations()
    }

    private fun loadDestinations() {
        viewModelScope.launch {
            runCatching { getDestinationUseCase() }
                .onSuccess { destinations ->
                    _uiState.value = DestinationsUiState.Success(destinations)
                }
                .onFailure { throwable ->
                    _uiState.value = DestinationsUiState.Error(
                        message = throwable.message ?: "Failed to load destinations"
                    )
                }
        }
    }
}
