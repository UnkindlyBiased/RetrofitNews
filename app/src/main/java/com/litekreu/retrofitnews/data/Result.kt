package com.litekreu.retrofitnews.data

sealed class Result<T>(
    val data: T? = null,
    val message: String? = null
) {
    class Success<T>(data: T?) : Result<T>(data)
    class Error<T>(data: T? = null, message: String? = null): Result<T>(data, message)
}