package com.entin.data.utils

/**
 * Extension function to help make safe internet request
 * Returns Kotlin Result success with result or failure with exception
 */

suspend fun <T: Any> safeApiRequest(requestFunc: suspend () -> T): Result<T> {
    return try {
        Result.success(requestFunc.invoke())
    } catch (e: Exception) {
        Result.failure(e)
    }
}