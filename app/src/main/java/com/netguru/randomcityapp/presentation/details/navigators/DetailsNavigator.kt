package com.netguru.randomcityapp.presentation.details.navigators

import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.netguru.domain.models.CityModel
import com.netguru.randomcityapp.R
import com.netguru.randomcityapp.core.Constants.CLEAR_SELECTED_CITY_FLAG_KEY
import com.netguru.randomcityapp.core.navigators.BaseFragmentNavigator
import com.netguru.randomcityapp.presentation.details.fragments.DetailsFragment
import javax.inject.Inject

interface DetailsNavigator {
    fun navigateBackToList(city: CityModel)
    fun setClearDetailsFlag()
    fun registerMapReadyCallback(callback: OnMapReadyCallback)
}

class DetailsNavigatorImpl @Inject constructor(fragment: DetailsFragment) :
    BaseFragmentNavigator<DetailsFragment>(fragment), DetailsNavigator {

    override fun navigateBackToList(city: CityModel) {
        navController?.previousBackStackEntry?.savedStateHandle?.set(CLEAR_SELECTED_CITY_FLAG_KEY, false)
        navController?.popBackStack(R.id.ListFragment, false)
    }

    override fun setClearDetailsFlag() {
        navController?.previousBackStackEntry?.savedStateHandle?.set(CLEAR_SELECTED_CITY_FLAG_KEY, true)
    }

    override fun registerMapReadyCallback(callback: OnMapReadyCallback) {
        val mapFragment = fragment
            ?.childFragmentManager
            ?.findFragmentById(R.id.mapFragment) as? SupportMapFragment

        mapFragment?.getMapAsync(callback)
    }
}