package com.entin.domain.model

/**
 * Main Domain Model of Forecast Weather
 */

data class CityWeatherDomainModel(
    val name: String,
    val weatherListDomainModel: List<WeatherItemDomainModel>,
)
