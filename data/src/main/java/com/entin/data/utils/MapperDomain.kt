package com.entin.data.utils

import com.entin.data.model.ApiWeatherResponse
import com.entin.data.model.WeatherInfo
import com.entin.domain.model.CityWeatherDomainModel
import com.entin.domain.model.WeatherItemDomainModel
import java.text.SimpleDateFormat
import java.util.*

fun WeatherInfo.mapToWeatherItem(): WeatherItemDomainModel =
    WeatherItemDomainModel(
        time = convertLongToTime(this.dt),
        icon = "http://openweathermap.org/img/w/" + this.weather[0].icon + ".png",
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
    val format = SimpleDateFormat("HH:mm", Locale.US)
    return format.format(Date(time * THOUSAND))
}

// Correct Long Unix Epoch time
const val THOUSAND = 1000L