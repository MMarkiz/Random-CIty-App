package com.netguru.randomcityapp.presentation.list.di

import com.netguru.randomcityapp.presentation.list.navigators.ListNavigator
import com.netguru.randomcityapp.presentation.list.navigators.ListNavigatorImpl
import dagger.Binds
import dagger.Module

@Module
interface ListFragmentModule {

    @Binds
    fun provideListNavigator(navigator: ListNavigatorImpl): ListNavigator
}