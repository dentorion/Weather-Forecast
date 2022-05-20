package com.entin.data.utils

import com.entin.data.model.ApiWeatherResponse
import com.entin.data.model.WeatherInfo
import com.entin.domain.model.CityWeatherDomainModel
import com.entin.domain.model.WeatherItemDomainModel
import java.text.SimpleDateFormat
import java.util.*

/**
 * Mapper
 * ApiWeatherResponse converts into Domain Model to be show for user.
 */

fun WeatherInfo.mapToWeatherItem(): WeatherItemDomainModel =
    WeatherItemDomainModel(
        time = convertLongToTime(this.dt),
        icon = ADDRESS + this.weather[0].icon + FORMAT,
        description = this.weather[0].main,
        temp = this.main.temp.toInt(),
        humid = this.main.humidity,
    )

fun ApiWeatherResponse.mapToDomain(): CityWeatherDomainModel {
    val resultList: MutableList<WeatherItemDomainModel> = mutableListOf()
    this.list.forEach { raw ->
        resultList.add(raw.mapToWeatherItem())
    }

    return CityWeatherDomainModel(
        name = this.city.name,
        weatherListDomainModel = resultList,
    )
}

fun convertLongToTime(time: Long): String {
    val format = SimpleDateFormat(TIME_FORMAT, Locale.US)
    return format.format(Date(time * THOUSAND))
}

// Correct Long Unix Epoch time
const val THOUSAND = 1000L

// Web address of icon
const val ADDRESS = "http://openweathermap.org/img/w/"

// Format icon
const val FORMAT = ".png"

// Time format
const val TIME_FORMAT = "d.MM - HH:mm"