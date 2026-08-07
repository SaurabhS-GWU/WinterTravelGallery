package com.example.wintertravelgallery.domain

import javax.inject.Inject

class GetDestinationUseCase @Inject constructor(
    private val destinationRepository: DestinationRepository
) {
    suspend operator fun invoke(): List<DestinationModel> {
        return destinationRepository.getDestinations()
    }
}