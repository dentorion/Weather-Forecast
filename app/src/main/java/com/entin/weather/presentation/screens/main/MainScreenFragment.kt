package com.entin.weather.presentation.screens.main

import android.content.Context
import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.SnapHelper
import com.airbnb.epoxy.Carousel
import com.airbnb.epoxy.EpoxyAsyncUtil
import com.airbnb.epoxy.carousel
import com.entin.weather.R
import com.entin.weather.core.epoxy.withModelsFrom
import com.entin.weather.databinding.FragmentMainScreenBinding
import com.entin.weather.presentation.screens.main.epoxy.WeatherItemModel_
import com.entin.weather.presentation.screens.main.epoxy.cityLabel
import com.entin.weather.presentation.utils.*
import com.github.rubensousa.gravitysnaphelper.GravitySnapHelper
import dagger.hilt.android.AndroidEntryPoint

/**
 * Main Screen Fragment
 * Shows weather forecast to user
 */

@AndroidEntryPoint
class MainScreenFragment : Fragment() {

    private var _binding: FragmentMainScreenBinding? = null
    private val binding get() = _binding!!
    private val viewModel: MainScreenViewModel by viewModels()
    private lateinit var carouselPadding: Carousel.Padding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMainScreenBinding.inflate(inflater, container, false)

        observeForecast()

        return binding.root
    }

    private fun observeForecast() {
        observe(viewModel.stateMainScreen) { result ->
            setupEpoxy()
            setState(result)
        }
    }

    private fun setState(result: ViewResult<MainScreenViewState>) {
        when (result) {
            is Fail -> getFail()
            is Pending -> getPending()
            is Success -> getSuccess(result.data)
        }
    }

    private fun getSuccess(data: MainScreenViewState) {
        progressBar(false)
        showData(data)
    }

    private fun getPending() {
        progressBar(true)
    }

    private fun getFail() {
        progressBar(false)
        errorMessage()
    }

    private fun showData(data: MainScreenViewState) {
        binding.mainScreenEpoxyRecyclerview.withModels {
            data.cities.forEach { cityWeather ->
                cityLabel {
                    id(cityWeather.name)
                    cityName(cityWeather.name)
                }
                carousel {
                    id(cityWeather.name.hashCode())
                    withModelsFrom(cityWeather.weatherListDomainModel) {
                        WeatherItemModel_()
                            .id(it.temp + it.humid)
                            .weatherItem(it)
                            .onClick { }
                    }
                    padding(carouselPadding)
                }
            }
        }
    }

    private fun setupEpoxy() {
        // Padding between carousel items
        carouselPadding = Carousel.Padding.dp(0, 0, 0, 0, 0)

        // Help to move carousel items smoothly
        Carousel.setDefaultGlobalSnapHelperFactory(object : Carousel.SnapHelperFactory() {
            override fun buildSnapHelper(context: Context?): SnapHelper {
                return GravitySnapHelper(Gravity.CENTER)
            }
        })

        // Epoxy calculating on Back Thread
        EpoxyAsyncUtil.getAsyncBackgroundHandler()
    }

    private fun progressBar(value: Boolean) {
        binding.mainScreenProgressBar.isVisible = value
    }

    private fun errorMessage() {
        Toast.makeText(
            requireContext(),
            getString(R.string.error_fetch_weather),
            Toast.LENGTH_SHORT
        ).show()
    }
}
