package com.netguru.randomcityapp.presentation.main.di

import androidx.lifecycle.ViewModel
import com.netguru.randomcityapp.core.di.ViewModelKey
import com.netguru.randomcityapp.presentation.main.viewmodels.MainViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
interface MainActivityModule {

    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel::class)
    fun mainViewModel(viewModel: MainViewModel): ViewModel
}