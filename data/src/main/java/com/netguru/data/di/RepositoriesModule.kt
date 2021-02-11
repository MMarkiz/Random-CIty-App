package com.netguru.data.di

import com.netguru.data.repositories.MyDatabaseRepositoryImpl
import com.netguru.domain.repositories.MyDatabaseRepository
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module
interface RepositoriesModule {

    @Binds
    @Singleton
    fun provideMyDatabaseRepository(myDatabaseRepository: MyDatabaseRepositoryImpl): MyDatabaseRepository
}