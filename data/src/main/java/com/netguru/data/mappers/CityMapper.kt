package com.netguru.data.mappers

import com.netguru.data.models.CityEntity
import com.netguru.domain.models.CityModel

fun CityModel.toEntity(): CityEntity {
    return CityEntity(created, name, color)
}

fun CityEntity.toDomain(): CityModel {
    return CityModel(created, name, color)
}