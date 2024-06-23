package com.example.newsapp.utilities

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bumptech.glide.integration.compose.GlideImage
import com.example.newsapp.R
import com.example.newsapp.model.API.NewsItem
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.bumptech.glide.integration.compose.placeholder

// i will use it in the news screen to hold each new
@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun NewsCard(newsItem: NewsItem?) // this fun take an object from the type of NewsItem and puts its content into composable
{
    Card(
        modifier = Modifier.padding(8.dp),
        colors = CardDefaults.cardColors(containerColor = Color.Transparent)
    ) {
        GlideImage(
            model = newsItem?.urlToImage ?: "",
            contentDescription = stringResource(R.string.news_image),
            modifier = Modifier
                .padding(8.dp)
                .fillMaxWidth(),
            contentScale = ContentScale.Fit,
            loading = placeholder(R.drawable.splash_logo)
        )
        Text(
            text = newsItem?.source?.name ?: "",
            modifier = Modifier.padding(horizontal = 8.dp),
            fontSize = 10.sp
        )
        Text(
            text = newsItem?.title ?: "",
            modifier = Modifier.padding(horizontal = 8.dp),
            fontSize = 14.sp, fontWeight = FontWeight.Medium
        )
        Text(
            text = newsItem?.publishedAt ?: "",
            modifier = Modifier
                .padding(horizontal = 8.dp)
                .align(Alignment.End),
            fontSize = 13.sp
        )
    }


}