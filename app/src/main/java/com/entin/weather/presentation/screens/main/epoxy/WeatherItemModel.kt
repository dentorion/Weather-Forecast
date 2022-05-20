package com.entin.weather.presentation.screens.main.epoxy

import android.annotation.SuppressLint
import android.widget.ImageView
import android.widget.TextView
import com.airbnb.epoxy.EpoxyAttribute
import com.airbnb.epoxy.EpoxyModelClass
import com.airbnb.epoxy.EpoxyModelWithHolder
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.entin.domain.model.WeatherItemDomainModel
import com.entin.weather.R
import com.entin.weather.core.epoxy.EpoxyKotlinHolder

/**
 * Epoxy item
 * Weather Item rectangle
 */

@SuppressLint("NonConstantResourceId")
@EpoxyModelClass(layout = R.layout.epoxy_weather_item)
abstract class WeatherItemModel : EpoxyModelWithHolder<WeatherItemModelHolder>() {

    @EpoxyAttribute
    lateinit var weatherItem: WeatherItemDomainModel

    @EpoxyAttribute
    lateinit var onClick: () -> Unit

    override fun bind(holder: WeatherItemModelHolder) {
        holder.iconView.setOnClickListener {
            onClick()
        }

        Glide.with(holder.iconView)
            .load(weatherItem.icon)
            .transform(CenterCrop())
            .diskCacheStrategy(DiskCacheStrategy.ALL)
            .error(R.drawable.red_rectangle)
            .into(holder.iconView)

        val humidValue = weatherItem.humid.toString() + HUMIDITY_LABEL
        val tempValue = weatherItem.temp.toString() + TEMPERATURE_LABEL

        holder.time.text = weatherItem.time
        holder.description.text = weatherItem.description
        holder.temperature.text = tempValue
        holder.humidity.text = humidValue
    }
}

class WeatherItemModelHolder : EpoxyKotlinHolder() {
    val iconView by bind<ImageView>(R.id.main_screen_weather_item_icon)
    val time by bind<TextView>(R.id.main_screen_weather_item_time)
    val description by bind<TextView>(R.id.main_screen_weather_item_description)
    val temperature by bind<TextView>(R.id.main_screen_weather_item_temperature)
    val humidity by bind<TextView>(R.id.main_screen_weather_item_humidity)
}

const val HUMIDITY_LABEL = "%"
const val TEMPERATURE_LABEL = "°"