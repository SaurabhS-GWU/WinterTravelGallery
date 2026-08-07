package com.example.wintertravelgallery.ui

import androidx.navigation3.runtime.NavKey
import kotlinx.serialization.Serializable
@Serializable
sealed class Screen: NavKey {
    @Serializable
    data object DestinationsScreen : Screen()

    @Serializable
    data class DestinationDetails(val destinationId: String) :Screen()
}