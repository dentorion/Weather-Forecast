package com.entin.weather.presentation.utils

/**
 * Result class represents answer from ViewModel to Fragment
 */

sealed class ViewResult<T>

/**
 * Operation is in progress
 */
class Pending<T> : ViewResult<T>()

/**
 * Operation has finished successfully
 */
class Success<T>(val data: T) : ViewResult<T>()

/**
 * Operation has finished with error
 */
class Fail<T> : ViewResult<T>()

/**
 * Get success value of [ViewResult] if it is possible; otherwise return NULL.
 */
fun <T> ViewResult<T>?.takeIfSuccess(): T? {
    return if (this is Success)
        this.data
    else
        null
}