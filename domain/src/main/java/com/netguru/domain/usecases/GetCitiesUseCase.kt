package com.netguru.domain.usecases

import com.netguru.domain.models.CityModel
import com.netguru.domain.repositories.MyDatabaseRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import javax.inject.Inject
import javax.inject.Named

open class GetCitiesUseCase @Inject constructor(
    private val myDatabaseRepository: MyDatabaseRepository,
    @param:Named("io") private val dispatcher: CoroutineDispatcher
) : UseCase<List<CityModel>, Unit>() {

    override suspend fun run(params: Unit): List<CityModel> = withContext(dispatcher) {
        myDatabaseRepository.getCities()
    }
}