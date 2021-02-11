package com.netguru.data.repositories

import com.netguru.data.dao.CityDao
import com.netguru.data.mappers.toDomain
import com.netguru.data.mappers.toEntity
import com.netguru.domain.models.CityModel
import com.netguru.domain.repositories.MyDatabaseRepository
import javax.inject.Inject

class MyDatabaseRepositoryImpl @Inject constructor(
    private val cityDao: CityDao
) : MyDatabaseRepository {

    override suspend fun getCities(): List<CityModel> {
        return cityDao.getCities().map { it.toDomain() }
    }

    override suspend fun insertCity(city: CityModel) {
        cityDao.insertCity(city.toEntity())
    }
}