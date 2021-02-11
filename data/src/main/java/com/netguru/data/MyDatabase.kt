package com.netguru.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.netguru.data.dao.CityDao
import com.netguru.data.models.CityEntity

@Database(entities = [CityEntity::class], version = 1, exportSchema = false)
abstract class MyDatabase : RoomDatabase() {

    abstract fun getCityDao(): CityDao

    companion object {
        const val NAME = "cities_database"
    }
}