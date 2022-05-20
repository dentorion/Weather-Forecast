package com.entin.weather.presentation.screens.main.epoxy

import android.annotation.SuppressLint
import android.widget.TextView
import com.airbnb.epoxy.EpoxyAttribute
import com.airbnb.epoxy.EpoxyModelClass
import com.airbnb.epoxy.EpoxyModelWithHolder
import com.entin.weather.R
import com.entin.weather.core.epoxy.EpoxyKotlinHolder

/**
 * Epoxy item
 * City Label
 */

@SuppressLint("NonConstantResourceId")
@EpoxyModelClass(layout = R.layout.epoxy_city_label)
abstract class CityLabelModel : EpoxyModelWithHolder<CityLabelModelHolder>() {

    @EpoxyAttribute
    lateinit var cityName: String

    override fun bind(holder: CityLabelModelHolder) {
        holder.apply {
            labelView.text = cityName
        }
    }
}

class CityLabelModelHolder : EpoxyKotlinHolder() {
    val labelView by bind<TextView>(R.id.all_elements_label)
}