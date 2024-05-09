//i will create a retrofit object here which is responsable for implement the interface
//Retrofit adapts a java interface to HTTP calls by using annotations on the declared methods to define how requests are made.
// Create instances using the builder and pass your interface to create to generate an implementation.
package com.example.newsapp.API

import android.util.Log
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.logging.Level

object RetrofitObject { // object mean that is an singlton object


    //logging interceptor
    ;
    val loggingInterceptor = HttpLoggingInterceptor { message ->
        Log.e("apiRes", message)
    }
        .apply {
            level = HttpLoggingInterceptor.Level.BODY
        }

    val client = OkHttpClient.Builder()
        .addInterceptor(loggingInterceptor)
        .build();

    val retrofit = Retrofit.Builder()
        .client(client)
        .baseUrl("https://newsapi.org/v2/")
        .addConverterFactory(GsonConverterFactory.create())
        .build() // the retrofit object has created


    // need to pass the interface to the retrofit object to implement it


    fun apiInterfaceImplementationByRetrofit(): ApiNewsServices { //return object from the interface
        return retrofit.create(ApiNewsServices::class.java)

    }


}