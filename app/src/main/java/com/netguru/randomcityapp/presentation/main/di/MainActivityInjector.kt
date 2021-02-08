package com.netguru.randomcityapp.presentation.main.di

import com.netguru.randomcityapp.core.di.ActivityScope
import com.netguru.randomcityapp.presentation.main.activities.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class MainActivityInjector {

    @ActivityScope
    @ContributesAndroidInjector(modules = [MainActivityFragmentsInjector::class])
    abstract fun provideMainActivity(): MainActivity

}