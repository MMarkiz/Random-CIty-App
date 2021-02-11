package com.netguru.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.netguru.data.models.CityEntity

@Dao
interface CityDao {

    @Query("SELECT * FROM CityEntity")
    fun getCities(): List<CityEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertCity(cityEntity: CityEntity)
}