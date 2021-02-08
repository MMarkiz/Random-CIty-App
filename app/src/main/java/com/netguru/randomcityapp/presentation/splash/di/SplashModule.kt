package com.netguru.randomcityapp.presentation.splash.di

import com.netguru.randomcityapp.presentation.splash.navigators.SplashNavigator
import com.netguru.randomcityapp.presentation.splash.navigators.SplashNavigatorImpl
import dagger.Binds
import dagger.Module

@Module
interface SplashModule {

    @Binds
    fun provideSplashNavigator(navigator: SplashNavigatorImpl): SplashNavigator
}