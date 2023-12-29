package com.litekreu.retrofitnews.presentation

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.core.content.ContextCompat.startActivity
import coil.compose.AsyncImage
import com.litekreu.retrofitnews.data.model.Article

@Composable
fun MainScreen(
    viewModel: NewsViewModel
) {
    val articles = viewModel.newsState.collectAsState()
    LazyColumn(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        items(articles.value) { article ->
            CardItem(article)
        }
    }
}

@Composable
fun CardItem(article: Article) {
    val context = LocalContext.current
    val intent = Intent(Intent.ACTION_VIEW).apply {
        data = Uri.parse(article.url)
    }
    Card(
        modifier = Modifier
            .width(344.dp)
            .padding(horizontal = 16.dp)
            .clip(RoundedCornerShape(20.dp))
            .clickable {
                startActivity(context, intent, null)
            },
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.tertiaryContainer,
            contentColor = MaterialTheme.colorScheme.tertiary
        )
    ) {
        Column (
            modifier = Modifier.padding(8.dp)
        ) {
            AsyncImage(
                model = article.urlToImage,
                contentDescription = null,
                modifier = Modifier.clip(RoundedCornerShape(16.dp))
            )
            Text(
                text = article.title,
                style = MaterialTheme.typography.bodyLarge
            )
        }
    }
}