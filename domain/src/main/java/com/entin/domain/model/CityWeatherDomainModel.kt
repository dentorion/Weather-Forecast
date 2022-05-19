package com.entin.domain.model

data class CityWeatherDomainModel(
    val name: String,
    val weatherListDomainModel: List<WeatherItemDomainModel>,
)
