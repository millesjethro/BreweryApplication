package com.auf.breweryapplication.Services.Repository

import com.auf.breweryapplication.Models.BrewingInfoData
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface BreweriesAPI {
    @GET("/breweries/random")
    suspend fun getRandomBreweries(
        @Query("size") size: Int
    ) : Response<BrewingInfoData>
    @GET("/breweries")
    suspend fun getListBreweries(
        @Query("per_page") perpage: Int,
        @Query("by_type") type: String,
        @Query("page") page: Int
    ) : Response<BrewingInfoData>
}