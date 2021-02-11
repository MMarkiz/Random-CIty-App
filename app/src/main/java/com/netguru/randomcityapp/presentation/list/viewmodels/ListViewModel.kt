package com.netguru.randomcityapp.presentation.list.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.netguru.domain.models.CityModel
import javax.inject.Inject

class ListViewModel @Inject constructor() : ViewModel() {

    private val _selectedCity = MutableLiveData<CityModel>()
    val selectedCity: LiveData<CityModel> = _selectedCity

    fun changeSelectedCity(cityModel: CityModel?) {
        _selectedCity.value = cityModel
    }

    fun clearSelectedCity() {
        _selectedCity.value = null
    }
}