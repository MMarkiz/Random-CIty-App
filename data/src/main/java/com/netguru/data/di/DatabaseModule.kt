package com.netguru.data.di

import android.content.Context
import androidx.room.Room
import com.netguru.data.MyDatabase
import com.netguru.data.dao.CityDao
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module
class DatabaseModule {

    @Singleton
    @Provides
    fun provideMyDatabase(context: Context): MyDatabase {
        return Room.databaseBuilder(context, MyDatabase::class.java, MyDatabase.NAME).build()
    }

    @Singleton
    @Provides
    fun provideCityDao(database: MyDatabase): CityDao {
        return database.getCityDao()
    }
}