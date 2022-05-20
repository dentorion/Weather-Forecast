package com.entin.data.repository

import com.entin.data.remote.RemoteDataSource
import com.entin.data.utils.mapToDomain
import com.entin.domain.model.CityWeatherDomainModel
import com.entin.domain.repository.Repository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

/**
 * [Repository] interface implementation.
 * In future cities can be moved to database to be edited by user preferences.
 */

class RepositoryImpl @Inject constructor(
    private val remoteSource: RemoteDataSource,
) : Repository {

    // City list. Can be downloaded from SQL Lite DB or DataStore or Internet and so on.
    private val cityIdList: Map<String, String> = mapOf(
        "Warsaw" to "756135",
        "Wroclaw" to "3081368",
        "Krakow" to "3094802",
        "Poznan" to "3088171",
        "Lodz" to "3093133",
        "Gdansk" to "3099434",
    )

    // Result list
    private val cityWeatherList: MutableList<CityWeatherDomainModel> = mutableListOf()

    // Download data from ApiWeather and add it to result list.
    override fun getWeatherForecast(): Flow<Result<List<CityWeatherDomainModel>>> = flow {
        cityIdList.forEach { (_, cityId) ->
            remoteSource.getWeatherForecastByCityId(cityId)
                .onSuccess { response ->
                    cityWeatherList.add(response.mapToDomain())
                }.onFailure { e ->
                    emit(Result.failure(e))
                    return@flow
                }
        }

        emit(Result.success(cityWeatherList))
    }
}