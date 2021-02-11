package com.netguru.domain.usecases

import com.netguru.domain.models.CityModel
import com.netguru.domain.repositories.MyDatabaseRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import javax.inject.Inject
import javax.inject.Named

class SaveCityUseCase @Inject constructor(
    private val myDatabaseRepository: MyDatabaseRepository,
    @param:Named("io") private val dispatcher: CoroutineDispatcher
) : UseCase<Unit, CityModel>() {

    override suspend fun run(params: CityModel): Unit = withContext(dispatcher) {
        myDatabaseRepository.insertCity(params)
    }
}