package com.netguru.randomcityapp.presentation.details.di

import androidx.lifecycle.ViewModel
import com.netguru.randomcityapp.core.di.ViewModelKey
import com.netguru.randomcityapp.presentation.details.navigators.DetailsNavigator
import com.netguru.randomcityapp.presentation.details.navigators.DetailsNavigatorImpl
import com.netguru.randomcityapp.presentation.details.viewmodels.DetailsViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
interface DetailsFragmentModule {

    @Binds
    fun provideDetailsNavigator(navigator: DetailsNavigatorImpl): DetailsNavigator

    @Binds
    @IntoMap
    @ViewModelKey(DetailsViewModel::class)
    fun detailsViewModel(viewModel: DetailsViewModel): ViewModel
}