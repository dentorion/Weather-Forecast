package com.entin.data.model

/**
 * Model for ApiWeather to build RAW response.
 * If needed to get more information from server - add fields according to JSON response.
 */

data class ApiWeatherResponse(
    val city: CityInfo,
    val list: List<WeatherInfo>
)

data class CityInfo(
    val id: Int,
    val name: String,
    val country: String,
    val sunrise: Long,
    val sunset: Long,
)

data class WeatherInfo(
    val dt: Long,
    val main: Main,
    val weather: List<Weather>,
)

data class Main(
    val temp: Float,
    val humidity: Int,
)

data class Weather(
    val main: String,
    val icon: String,
)
