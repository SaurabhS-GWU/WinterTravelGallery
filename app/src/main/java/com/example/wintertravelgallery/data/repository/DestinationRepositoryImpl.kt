package com.example.wintertravelgallery.data.repository

import com.example.wintertravelgallery.data.mapper.toDomain
import com.example.wintertravelgallery.data.remote.Destination
import com.example.wintertravelgallery.domain.DestinationModel
import com.example.wintertravelgallery.domain.DestinationRepository
import javax.inject.Inject

class DestinationRepositoryImpl @Inject constructor(): DestinationRepository {
    override suspend fun getDestinations(): List<DestinationModel> {
        return Destination.entries.map{
            it.toDomain()
        }
    }
}