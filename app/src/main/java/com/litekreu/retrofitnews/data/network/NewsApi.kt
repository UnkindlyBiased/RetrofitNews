package com.litekreu.retrofitnews.data.network

import com.litekreu.retrofitnews.data.model.News
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApi {
    @GET("everything")
    suspend fun getNews(
        @Query("q") quote: String = "verstappen",
        @Query("language") language: String = "en",
        @Query("apiKey") apiKey: String = "3398295c3dba4ddaad40a423c556c9ea"
    ) : News

    companion object {
        const val BaseUrl = "https://newsapi.org/v2/"
    }
}