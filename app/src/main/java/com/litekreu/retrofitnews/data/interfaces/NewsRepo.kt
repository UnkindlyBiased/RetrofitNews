package com.litekreu.retrofitnews.data.interfaces

import com.litekreu.retrofitnews.data.Result
import com.litekreu.retrofitnews.data.model.Article
import kotlinx.coroutines.flow.Flow

interface NewsRepo {
    suspend fun getNewsList(): Flow<Result<List<Article>>>
}