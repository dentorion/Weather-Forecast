package com.entin.weather.presentation.screens.main

import com.entin.domain.model.CityWeatherDomainModel

/**
 * ViewState for [MainScreenFragment]
 */

data class MainScreenViewState(
    val cities: List<CityWeatherDomainModel>
)
