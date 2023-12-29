package com.litekreu.retrofitnews.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.litekreu.retrofitnews.data.Result
import com.litekreu.retrofitnews.data.interfaces.NewsRepo
import com.litekreu.retrofitnews.data.model.Article
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class NewsViewModel (
    private val newsRepository: NewsRepo
) : ViewModel() {
    private val _newsState = MutableStateFlow<List<Article>>(emptyList())
    val newsState = _newsState.asStateFlow()

    init {
        viewModelScope.launch {
            newsRepository.getNewsList().collectLatest { result ->
                when(result) {
                    is Result.Error -> { }
                    is Result.Success -> {
                        result.data?.let { articles ->
                            _newsState.update { articles }
                        }
                    }
                }
            }
        }
    }
}