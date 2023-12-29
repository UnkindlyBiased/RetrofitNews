package com.litekreu.retrofitnews.data.interfaces

import com.litekreu.retrofitnews.data.network.NewsApi
import kotlinx.coroutines.flow.Flow
import com.litekreu.retrofitnews.data.Result
import com.litekreu.retrofitnews.data.model.Article
import kotlinx.coroutines.flow.flow


class NewsRepoImplement (private val api: NewsApi) : NewsRepo {
    override suspend fun getNewsList(): Flow<Result<List<Article>>> {
        return flow {
            val apiNews = try {
                api.getNews()
            }
            catch (e: Exception) {
                e.printStackTrace()
                emit(Result.Error(message = "Some kind of error"))
                return@flow
            }
            emit(Result.Success(apiNews.articles))
        }
    }
}