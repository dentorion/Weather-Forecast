package com.entin.data.api

import androidx.annotation.Keep
import com.entin.data.BuildConfig
import com.entin.data.model.ApiWeatherResponse
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * ApiWeather Retrofit Interface for fetching weather data.
 */

interface ApiWeather {

    @GET(GET_FORECAST_URL)
    suspend fun getWeatherByCity(
        @Query(ID) cityId: String,
        @Query(UNITS) units: String = METRIC,
        @Query(APPID) appId: String = BuildConfig.MY_KEY
    ): ApiWeatherResponse
}

// Part of query
@Keep
private const val GET_FORECAST_URL = "forecast"

@Keep
private const val ID = "id"

@Keep
private const val UNITS = "units"

@Keep
private const val APPID = "appid"

@Keep
private const val METRIC = "metric"