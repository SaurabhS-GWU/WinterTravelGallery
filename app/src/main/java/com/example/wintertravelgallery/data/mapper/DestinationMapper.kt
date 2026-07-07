package com.example.wintertravelgallery.data.mapper

import com.example.wintertravelgallery.data.remote.Destination
import com.example.wintertravelgallery.domain.DestinationModel

fun Destination.toDomain(): DestinationModel{
    return DestinationModel(
        title = this.title,
        urls = this.imageUrls
    )
}

fun List<Destination>.toDomain(): List<DestinationModel>{
    return this.map{ it.toDomain() }
}