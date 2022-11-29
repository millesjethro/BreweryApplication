package com.auf.breweryapplication.Services.Repository

import com.auf.breweryapplication.Models.BrewingInfoData
import retrofit2.Response
import retrofit2.http.GET

interface SearchBreweriesAPI {
    @GET("/breweries/search")
    suspend fun getBreweries() : Response<BrewingInfoData>
}