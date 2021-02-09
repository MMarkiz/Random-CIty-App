package com.netguru.randomcityapp.presentation.details.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.netguru.domain.CityModel
import javax.inject.Inject

class DetailsViewModel @Inject constructor() : ViewModel() {

    private val _city = MutableLiveData<CityModel>()
    val city: LiveData<CityModel> = _city

    var wasLastTimeTabletLandscape: Boolean? = null

    fun initialize(cityModel: CityModel){
        _city.value = cityModel
    }
}