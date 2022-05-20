package com.entin.weather.presentation.utils

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer

/**
 * Wrapper under LiveData Observer
 */

fun <T> LifecycleOwner.observe(liveData: LiveData<T>, observer: Observer<T>) {
    liveData.observe(this, observer)
}
