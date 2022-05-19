package com.entin.weather.presentation.screens.main

import com.entin.domain.model.CityWeatherDomainModel

data class MainScreenViewState(
    val cities: List<CityWeatherDomainModel>
)