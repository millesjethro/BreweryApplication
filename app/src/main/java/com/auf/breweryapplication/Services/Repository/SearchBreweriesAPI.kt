package com.auf.breweryapplication.Services.Repository

import com.auf.breweryapplication.Models.BrewingInfoData
import com.auf.breweryapplication.Models.BrewingInformation
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface SearchBreweriesAPI {
    @GET("/breweries/search")
    suspend fun getBreweries() : Response<BrewingInfoData>
}