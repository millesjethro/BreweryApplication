package com.auf.breweryapplication.Services.Repository

import com.auf.breweryapplication.Models.BrewingInfoData
import retrofit2.Response
import retrofit2.http.GET

interface RandomBreweriesAPI {
    @GET("/breweries/random")
    suspend fun getRandomBreweries() : Response<BrewingInfoData>
}