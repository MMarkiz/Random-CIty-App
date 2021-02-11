package com.netguru.randomcityapp.presentation.details.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.android.gms.maps.model.LatLng
import com.netguru.domain.models.CityModel
import javax.inject.Inject

class DetailsViewModel @Inject constructor() : ViewModel() {

    private val _city = MutableLiveData<CityModel>()
    val city: LiveData<CityModel> = _city

    private val _cityLatLng = MutableLiveData<LatLng>()
    val cityLatLng: LiveData<LatLng> = _cityLatLng

    var wasLastTimeTabletLandscape: Boolean? = null

    fun initialize(cityModel: CityModel){
        _city.value = cityModel
    }

    fun postCityLatLng(cityLatLng: LatLng?){
        _cityLatLng.postValue(cityLatLng)
    }
}