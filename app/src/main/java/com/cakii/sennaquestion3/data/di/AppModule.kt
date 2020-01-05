package com.cakii.sennaquestion3.data.di

import android.content.Context
import com.cakii.sennaquestion3.App
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule(private val application: App) {

    @Provides
    @Singleton
    fun provideContext(): Context = application.applicationContext
}