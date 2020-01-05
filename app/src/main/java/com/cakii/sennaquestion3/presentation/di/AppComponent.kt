package com.cakii.sennaquestion3.presentation.di

import com.cakii.sennaquestion3.data.di.AppModule
import com.cakii.sennaquestion3.data.di.RemoteModule
import com.cakii.sennaquestion3.data.di.RepositoryModule
import com.cakii.sennaquestion3.viewmodel.RestaurantViewModel
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class, RemoteModule::class, RepositoryModule::class])
interface AppComponent {

    fun inject(viewModel: RestaurantViewModel)
}