package com.litekreu.retrofitnews

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.litekreu.retrofitnews.data.interfaces.NewsRepoImplement
import com.litekreu.retrofitnews.data.network.RetrofitObject
import com.litekreu.retrofitnews.presentation.MainScreen
import com.litekreu.retrofitnews.presentation.NewsViewModel
import com.litekreu.retrofitnews.ui.theme.RetrofitNewsTheme

class MainActivity : ComponentActivity() {
    @Suppress("UNCHECKED_CAST")
    private val newsViewModel by viewModels<NewsViewModel>(factoryProducer = {
        object : ViewModelProvider.Factory {
            override fun <T : ViewModel> create(modelClass: Class<T>): T {
                return NewsViewModel(NewsRepoImplement(RetrofitObject.api)) as T
            }
        }
    })
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RetrofitNewsTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MainScreen()
                }
            }
        }
    }
}

