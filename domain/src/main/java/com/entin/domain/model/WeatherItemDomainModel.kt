package com.entin.domain.model

/**
 * Inner Model of [CityWeatherDomainModel]
 */

data class WeatherItemDomainModel(
    val time: String,
    val icon: String,
    val description: String,
    val temp: Int,
    val humid: Int,
)