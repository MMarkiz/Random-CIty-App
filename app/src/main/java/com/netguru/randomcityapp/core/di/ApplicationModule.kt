package com.netguru.randomcityapp.core.di

import android.content.Context
import com.netguru.randomcityapp.MyApplication
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module(subcomponents = [])
class ApplicationModule {

    @Provides
    @Singleton
    fun provideContext(application: MyApplication): Context {
        return application
    }
}