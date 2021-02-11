package com.netguru.randomcityapp.presentation.main.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.netguru.domain.models.CityModel
import com.netguru.domain.usecases.GetCitiesUseCase
import com.netguru.domain.usecases.SaveCityUseCase
import com.netguru.randomcityapp.core.Constants.CITY_GENERATOR_INTERVAL_IN_MS
import com.netguru.randomcityapp.core.Constants.COLOR_BLACK
import com.netguru.randomcityapp.core.Constants.COLOR_BLUE
import com.netguru.randomcityapp.core.Constants.COLOR_GREEN
import com.netguru.randomcityapp.core.Constants.COLOR_RED
import com.netguru.randomcityapp.core.Constants.COLOR_WHITE
import com.netguru.randomcityapp.core.Constants.COLOR_YELLOW
import com.netguru.randomcityapp.core.extensions.applyAndSet
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.util.*
import javax.inject.Inject
import kotlin.collections.ArrayList

class MainViewModel @Inject constructor(
    private val getCitiesUseCase: GetCitiesUseCase,
    private val saveCityUseCase: SaveCityUseCase
) : ViewModel() {

    private val cities =
        listOf("Gdańsk", "Warszawa", "Poznań", "Białystok", "Wrocław", "Katowice", "Kraków")
    private val colors =
        listOf(COLOR_YELLOW, COLOR_GREEN, COLOR_BLUE, COLOR_RED, COLOR_BLACK, COLOR_WHITE)

    private val _generatedCities = MutableLiveData<ArrayList<CityModel>>(ArrayList())
    val generatedCities: LiveData<ArrayList<CityModel>> = _generatedCities

    lateinit var cityGeneratorJob: Job


    init {
        getCities()
    }

    fun startCityGenerator() {
        cityGeneratorJob = viewModelScope.launch {
            while (true) {
                delay(CITY_GENERATOR_INTERVAL_IN_MS)

                val city = CityModel(
                    Calendar.getInstance().timeInMillis,
                    cities.random(),
                    colors.random()
                )
                saveCity(city)
                _generatedCities.applyAndSet { it?.apply { add(city) } }
            }
        }
    }

    fun stopCityGenerator() {
        cityGeneratorJob.cancel()
    }

    private fun saveCity(city: CityModel){
        saveCityUseCase.invoke(viewModelScope, city)
    }

    fun getCities() {
//        _generatedCities.value?.addAll(listOf(CityModel(123,"afs","asf")))
        getCitiesUseCase.invoke(viewModelScope, Unit) { _generatedCities.value?.addAll(it) }
    }
}