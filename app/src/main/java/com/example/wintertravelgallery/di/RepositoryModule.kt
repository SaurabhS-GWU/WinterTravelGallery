package com.example.wintertravelgallery.di

import com.example.wintertravelgallery.data.repository.DestinationRepositoryImpl
import com.example.wintertravelgallery.domain.DestinationRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule{
    @Binds
    abstract fun getDestinationRepository(
        impl : DestinationRepositoryImpl
    ): DestinationRepository
}
