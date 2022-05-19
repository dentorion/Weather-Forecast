package com.entin.data.remote

import com.entin.data.api.ApiWeather
import com.entin.data.model.ApiWeatherResponse
import com.entin.data.utils.safeApiRequest
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RemoteDataSourceImpl @Inject constructor(
    private val apiService: ApiWeather
) : RemoteDataSource {

    override suspend fun getWeatherForecastByCityId(cityId: String): Result<ApiWeatherResponse> =
        safeApiRequest {
            apiService.getWeatherByCity(cityId)
        }
}