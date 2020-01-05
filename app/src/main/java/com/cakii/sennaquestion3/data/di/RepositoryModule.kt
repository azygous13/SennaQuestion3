package com.cakii.sennaquestion3.data.di

import com.cakii.sennaquestion3.data.service.Service
import com.cakii.sennaquestion3.repository.RestaurantRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepositoryModule {

    @Provides
    @Singleton
    fun provideRepository(remoteSource: Service): RestaurantRepository = RestaurantRepository(remoteSource)
}