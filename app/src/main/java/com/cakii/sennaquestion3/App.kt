package com.cakii.sennaquestion3

import android.app.Application
import com.cakii.sennaquestion3.data.di.AppModule
import com.cakii.sennaquestion3.data.di.RemoteModule
import com.cakii.sennaquestion3.data.di.RepositoryModule
import com.cakii.sennaquestion3.presentation.di.AppComponent
import com.cakii.sennaquestion3.presentation.di.DaggerAppComponent

class App : Application() {

    companion object {
        lateinit var instance: App
        lateinit var component: AppComponent
        private const val BASE_URL = "https://order-plz.herokuapp.com/"
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
        setUpDagger()
    }

    private fun setUpDagger() {
        component = DaggerAppComponent.builder()
                .appModule(AppModule(this))
                .remoteModule(RemoteModule(BASE_URL))
                .repositoryModule(RepositoryModule())
                .build()
    }
}