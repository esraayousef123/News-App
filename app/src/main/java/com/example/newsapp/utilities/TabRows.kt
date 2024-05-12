package com.example.newsapp.utilities

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ScrollableTabRow
import androidx.compose.material3.Tab
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.newsapp.API.RetrofitObject
import com.example.newsapp.model.API.ResponseFromApi
import com.example.newsapp.model.API.SourcesItem
import com.example.newsapp.model.Constant
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Callback
import kotlin.math.log


@Composable
// using in the news screen and i get the content of the tabs from API
fun SourceTabRow(modifier: Modifier) { // this fun that i will call to show the tapRow

    val slectedTabInedx = remember { // selected tab by defult the tab selected at first
        mutableIntStateOf(0)
    }
    val sourceslist = remember { // i will store the resources returned from the api in this list
        mutableStateListOf<SourcesItem?>()
    }

    LaunchedEffect(Unit) { // the body will be call just once not every time the composable change so i will call the api here

        RetrofitObject
            .apiInterfaceImplementationByRetrofit() // object from the api interface
            .getNewsSources(Constant.apiKey) // to return object from call class
            .enqueue(object : Callback<ResponseFromApi> {
                override fun onResponse(
                    call: Call<ResponseFromApi>,
                    response: retrofit2.Response<ResponseFromApi> // result from api

                ) {
                    if (response.isSuccessful) {
                        val sources = response.body()?.sources // list of sources returned from api
                        if (sources?.isNotEmpty() == true) {
                            sourceslist.addAll(sources) // list of sources from api

                        } else {

                            // بيانات فارغة
                            Log.e("API Error", "Empty response body")
                        }


                    } else {
                        // الاستجابة غير ناجحة
                        Log.e("API Error", "Unsuccessful response: ${response.code()}")
                    }

                }


                override fun onFailure(call: Call<ResponseFromApi>, t: Throwable) {
                    Log.e("APIError", "Failed to retrieve data: ${t.message}")
                }

            })//enqueue fun is to run this code on the background therad , to check the return data
    }
    if(sourceslist.isNotEmpty()){ // before this line the app was crashing so i have to check firts that the list is not empty before rendering the view
    ScrollableTabRow(
        selectedTabIndex = slectedTabInedx.intValue, modifier = modifier,
        indicator = {},
        divider = {},
        edgePadding = 8.dp


    ) { // composable / view that will be render
        sourceslist.forEachIndexed { index, sourcesItem ->
            Tab(
                selected = index == slectedTabInedx.intValue,
                onClick = { slectedTabInedx.intValue = index },
                selectedContentColor = Color.White,
                unselectedContentColor = Color.Green
            )
            {
                Text(
                    text = sourcesItem?.name ?: "",
                    modifier = if (index == slectedTabInedx.intValue)
                        Modifier // tab is selected
                            .padding(8.dp)
                            .background(Color.Green, RoundedCornerShape(50))
                            .padding(vertical = 8.dp, horizontal = 16.dp)
                    else
                        Modifier
                            .padding(8.dp)
                            .border(2.dp, Color.Green, CircleShape)

                            .padding(vertical = 8.dp, horizontal = 18.dp)
                    //try sometq


                )
            }


        }
    }


    }}





