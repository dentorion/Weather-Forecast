package com.entin.weather.presentation.screens.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class MainScreenViewModel : ViewModel() {

    init {
        fetchForecastWeather()
    }

    private val _stateScreen = MutableLiveData<Any>()
    val stateScreen: LiveData<Any> = _stateScreen

    private fun fetchForecastWeather() = viewModelScope.launch {
        /**
         * Not yet implemented
         * invoke Repository -> RemoteDataSource -> WeatherApi
         */
    }

}


