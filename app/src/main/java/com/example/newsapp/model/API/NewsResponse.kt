package com.example.newsapp.model.API

import com.google.gson.annotations.SerializedName

data class NewsResponse(

	@field:SerializedName("totalResults")
	val totalResults: Int? = null,

	@field:SerializedName("articles")
	val articles: List<NewsItem?>? = null,

	@field:SerializedName("status")
	val status: String? = null
)