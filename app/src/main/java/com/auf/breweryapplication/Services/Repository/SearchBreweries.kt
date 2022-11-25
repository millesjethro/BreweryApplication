package com.auf.breweryapplication.Services.Repository

import com.auf.breweryapplication.Models.BrewingInformation
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface SearchBreweries {
    @GET("/data/2.5/weather")
    suspend fun getTodaysWeather(
        @Query("q") q : String,
        @Query("appID") appid: String
    ) : Response<BrewingInformation>
}