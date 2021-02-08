package com.netguru.randomcityapp.presentation.splash.navigators

import com.netguru.randomcityapp.R
import com.netguru.randomcityapp.core.navigators.BaseFragmentNavigator
import com.netguru.randomcityapp.presentation.splash.fragments.SplashFragment
import javax.inject.Inject

interface SplashNavigator {
    fun navigateToList()
}

class SplashNavigatorImpl @Inject constructor(fragment: SplashFragment) :
    BaseFragmentNavigator<SplashFragment>(fragment), SplashNavigator {

    override fun navigateToList() {
        navController?.navigate(R.id.action_SplashFragment_to_ListFragment)
    }
}