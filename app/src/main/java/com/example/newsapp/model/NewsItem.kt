package com.example.newsapp.model
// each newخبر comes from the api will crate an object to store its data in
data class NewsItem(
    val newsImage : Int? = null,
    val time : String ? =null,
    val source : String? = null,
    val description :String?=null


)
