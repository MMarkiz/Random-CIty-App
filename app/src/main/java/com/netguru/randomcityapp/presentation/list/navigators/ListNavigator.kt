package com.netguru.randomcityapp.presentation.list.navigators

import android.os.Bundle
import androidx.navigation.fragment.NavHostFragment
import com.netguru.domain.models.CityModel
import com.netguru.randomcityapp.R
import com.netguru.randomcityapp.core.Constants
import com.netguru.randomcityapp.core.Constants.DETAILS_CITY_ARGUMENT_KEY
import com.netguru.randomcityapp.core.navigators.BaseFragmentNavigator
import com.netguru.randomcityapp.presentation.list.fragments.ListFragment
import com.netguru.randomcityapp.presentation.list.fragments.ListFragmentDirections
import javax.inject.Inject

interface ListNavigator {
    fun navigateToDetails(city: CityModel)
    fun getClearSelectedCityFlag(): Boolean?
}

class ListNavigatorImpl @Inject constructor(fragment: ListFragment) :
    BaseFragmentNavigator<ListFragment>(fragment), ListNavigator {

    override fun navigateToDetails(city: CityModel) {
        fragment?.run {
            val isTabletLandscape = context?.resources?.getBoolean(R.bool.isTabletLandscape)

            val bundle = Bundle()
            bundle.putParcelable(DETAILS_CITY_ARGUMENT_KEY, city)

            if (isTabletLandscape == true) {
                val navHostFragment =
                    childFragmentManager.findFragmentById(R.id.details_fragment_container) as NavHostFragment
                navHostFragment.navController.setGraph(R.navigation.nav_graph_details, bundle)
            } else {
                navController?.navigate(
                    ListFragmentDirections.actionListFragmentToDetailsFragment(city)
                )
            }
        }
    }

    override fun getClearSelectedCityFlag(): Boolean? {
        return navController?.currentBackStackEntry?.savedStateHandle?.getLiveData<Boolean>(Constants.CLEAR_SELECTED_CITY_FLAG_KEY)?.value
    }
}