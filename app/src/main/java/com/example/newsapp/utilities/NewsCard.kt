package com.example.newsapp.utilities

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.newsapp.R
import com.example.newsapp.model.NewsItem

// i will use it in the news screen to hold each new
@Composable
fun newsCard(newsItem: NewsItem) // this fun take an object from the type of NewsItem and puts its content into composable
{
    Card(
        modifier = Modifier.padding(8.dp),
        colors = CardDefaults.cardColors(containerColor = Color.Transparent)
    ) {
        Image(
            painter = painterResource(id = newsItem.newsImage ?: R.drawable.not_found_image),
            contentDescription = stringResource(R.string.nesw_image),
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
                .fillMaxHeight(.2f)
        )
        Text(
            text = newsItem.source ?: "",
            modifier = Modifier.padding(horizontal = 8.dp, vertical = 1.dp), fontSize = 10.sp
        )
        Text(
            text = newsItem.description ?: "",
            modifier = Modifier.padding(horizontal = 8.dp),
            fontSize = 14.sp,
            fontWeight = FontWeight.Medium
        )
        Text(
            text = newsItem.time ?: "",
            modifier = Modifier
                .padding(horizontal = 8.dp)
                .align(Alignment.End), fontSize = 13.sp


        )
    }


}