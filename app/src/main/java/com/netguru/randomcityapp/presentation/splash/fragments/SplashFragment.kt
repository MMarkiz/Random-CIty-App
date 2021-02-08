package com.netguru.randomcityapp.presentation.splash.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.netguru.randomcityapp.R
import com.netguru.randomcityapp.core.ui.BaseFragment
import com.netguru.randomcityapp.databinding.FragmentSplashBinding
import com.netguru.randomcityapp.presentation.main.viewmodels.MainViewModel
import com.netguru.randomcityapp.presentation.splash.navigators.SplashNavigator
import javax.inject.Inject

class SplashFragment : BaseFragment<FragmentSplashBinding>() {

    override val layoutId: Int
        get() = R.layout.fragment_splash

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private val mainViewModel: MainViewModel by activityViewModels { viewModelFactory }

    @Inject
    lateinit var navigator: SplashNavigator

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupObservers()
    }

    private fun setupObservers() {
        mainViewModel.generatedCities.observe(viewLifecycleOwner, Observer {
            if (it.isNotEmpty()) {
                navigator.navigateToList()
            }
        })
    }
}