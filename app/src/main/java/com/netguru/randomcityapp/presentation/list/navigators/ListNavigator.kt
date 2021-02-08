package com.netguru.randomcityapp.presentation.list.navigators

import com.netguru.domain.CityModel
import com.netguru.randomcityapp.core.navigators.BaseFragmentNavigator
import com.netguru.randomcityapp.presentation.list.fragments.ListFragment
import com.netguru.randomcityapp.presentation.list.fragments.ListFragmentDirections
import javax.inject.Inject

interface ListNavigator {
    fun navigateToDetails(city: CityModel)
}

class ListNavigatorImpl @Inject constructor(fragment: ListFragment) :
    BaseFragmentNavigator<ListFragment>(fragment), ListNavigator {

    override fun navigateToDetails(city: CityModel) {
        navController?.navigate(ListFragmentDirections.actionListFragmentToDetailsFragment(city))
    }
}