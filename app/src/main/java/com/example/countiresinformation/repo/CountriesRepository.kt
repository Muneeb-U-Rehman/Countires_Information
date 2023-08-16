package com.example.countiresinformation.repo

import com.example.countiresinformation.model.CountriesDataModel
import com.example.countiresinformation.network.ApiService

class CountriesRepository(private val apiService: ApiService) {

    suspend fun fetchData(): ArrayList<CountriesDataModel> {
        return apiService.getCountriesData()
    }
}