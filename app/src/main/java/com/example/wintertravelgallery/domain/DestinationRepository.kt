package com.example.wintertravelgallery.domain

interface DestinationRepository {
    suspend fun getDestinations():List<DestinationModel>
}