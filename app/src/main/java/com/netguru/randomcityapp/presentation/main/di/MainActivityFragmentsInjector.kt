package com.netguru.randomcityapp.presentation.main.di

import com.netguru.randomcityapp.core.di.FragmentScope
import com.netguru.randomcityapp.presentation.details.DetailsFragment
import com.netguru.randomcityapp.presentation.details.di.DetailsFragmentModule
import com.netguru.randomcityapp.presentation.list.fragments.ListFragment
import com.netguru.randomcityapp.presentation.list.di.ListFragmentModule
import com.netguru.randomcityapp.presentation.splash.di.SplashModule
import com.netguru.randomcityapp.presentation.splash.fragments.SplashFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class MainActivityFragmentsInjector {

    @FragmentScope
    @ContributesAndroidInjector(modules = [SplashModule::class])
    abstract fun provideSplashFragment(): SplashFragment

    @FragmentScope
    @ContributesAndroidInjector(modules = [ListFragmentModule::class])
    abstract fun provideListFragment(): ListFragment

    @FragmentScope
    @ContributesAndroidInjector(modules = [DetailsFragmentModule::class])
    abstract fun provideDetailsFragment(): DetailsFragment
}
