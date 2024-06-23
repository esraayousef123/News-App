// this is the interface which bring me the data from the API ,
// Retrofit will be responsable for create the imp of this interface
// so retrofit will be a singlton object
package com.example.newsapp.API

import com.example.newsapp.model.API.NewsResponse
import com.example.newsapp.model.API.SourcesResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiNewsServices {
@GET("top-headlines/sources") // end point
fun getNewsSources(
    @Query("apiKey")
    apiKey:String
) : Call<SourcesResponse> // i should make sure that this (Call) from type retrofit 2, this fun will return object from class call
@GET("/v2/everything") // to get each resource news
fun getNewsBySource(
    @Query("apiKey")
    apiKey:String,
    @Query("sources")
    sources:String?
) : Call<NewsResponse>

}