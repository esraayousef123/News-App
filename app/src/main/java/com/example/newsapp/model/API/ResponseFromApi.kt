package com.example.newsapp.model.API

data class ResponseFromApi(
	val sources: List<SourcesItem?>? = null,
	val status: String? = null
)
