package com.litekreu.retrofitnews.data.network

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitObject {
    private val httpClient: OkHttpClient = OkHttpClient.Builder().build()

    val api: NewsApi = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(NewsApi.BaseUrl)
        .client(httpClient)
        .build()
        .create(NewsApi::class.java)
}