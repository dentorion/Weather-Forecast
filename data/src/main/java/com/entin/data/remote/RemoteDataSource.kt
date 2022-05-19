package com.entin.data.remote

import com.entin.data.model.ApiWeatherResponse

interface RemoteDataSource {

    suspend fun getWeatherForecastByCityId(cityId: String): Result<ApiWeatherResponse>
}