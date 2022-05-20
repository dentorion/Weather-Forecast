package com.entin.domain.repository

import com.entin.domain.model.CityWeatherDomainModel
import kotlinx.coroutines.flow.Flow

/**
 * Repository interface
 * Fetches data from RemoteDataSource
 */

interface Repository {

    fun getWeatherForecast(): Flow<Result<List<CityWeatherDomainModel>>>
}