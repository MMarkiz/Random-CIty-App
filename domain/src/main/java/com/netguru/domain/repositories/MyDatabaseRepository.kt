package com.netguru.domain.repositories

import com.netguru.domain.models.CityModel

interface MyDatabaseRepository {

    suspend fun getCities(): List<CityModel>

    suspend fun insertCity(city: CityModel)
}