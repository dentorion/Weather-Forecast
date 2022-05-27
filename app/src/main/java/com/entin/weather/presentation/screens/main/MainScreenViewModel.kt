package com.entin.weather.presentation.screens.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.entin.domain.repository.Repository
import com.entin.weather.presentation.utils.Fail
import com.entin.weather.presentation.utils.Pending
import com.entin.weather.presentation.utils.Success
import com.entin.weather.presentation.utils.ViewResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * MainScreen ViewModel for [MainScreenFragment]
 * Gets data from [Repository] and prepare MainScreen ViewState to show.
 */

@HiltViewModel
class MainScreenViewModel @Inject constructor(
    private val repository: Repository,
) : ViewModel() {

    init {
        fetchForecastWeather()
    }

    private val _stateMainScreen = MutableLiveData<ViewResult<MainScreenViewState>>(Pending())
    val stateMainScreen: LiveData<ViewResult<MainScreenViewState>> = _stateMainScreen

    private fun fetchForecastWeather() = viewModelScope.launch(Dispatchers.IO) {
        repository.getWeatherForecast().collect { result ->
            result.onSuccess { list ->
                _stateMainScreen.postValue(Success(MainScreenViewState(cities = list)))
            }.onFailure {
                _stateMainScreen.postValue(Fail())
            }
        }
    }
}
