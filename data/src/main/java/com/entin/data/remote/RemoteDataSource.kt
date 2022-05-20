package com.entin.data.remote

import com.entin.data.model.ApiWeatherResponse

/**
 * Remote Data Source interface
 * Fetches data from ApiWeather
 */

interface RemoteDataSource {

    suspend fun getWeatherForecastByCityId(cityId: String): Result<ApiWeatherResponse>
}