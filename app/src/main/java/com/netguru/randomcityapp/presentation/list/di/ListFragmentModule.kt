package com.netguru.randomcityapp.presentation.list.di

import androidx.lifecycle.ViewModel
import com.netguru.randomcityapp.core.di.ViewModelKey
import com.netguru.randomcityapp.presentation.list.navigators.ListNavigator
import com.netguru.randomcityapp.presentation.list.navigators.ListNavigatorImpl
import com.netguru.randomcityapp.presentation.list.viewmodels.ListViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
interface ListFragmentModule {

    @Binds
    fun provideListNavigator(navigator: ListNavigatorImpl): ListNavigator

    @Binds
    @IntoMap
    @ViewModelKey(ListViewModel::class)
    fun listViewModel(viewModel: ListViewModel): ViewModel
}