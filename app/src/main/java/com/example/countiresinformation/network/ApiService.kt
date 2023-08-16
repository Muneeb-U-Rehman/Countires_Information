package com.example.countiresinformation.network

import com.example.countiresinformation.model.CountriesDataModel
import retrofit2.http.GET

interface ApiService {

    @GET("v3.1/all?fields=name,flags,population,area")
    suspend fun getCountriesData(): ArrayList<CountriesDataModel>
}