package com.example.countiresinformation.screens

enum class CountriesScreens {

    HomeScreen,
    CountriesDetail;

    companion object{

        fun fromRoute(route: String?): CountriesScreens =
            when(route?.substringBefore("/")){
                HomeScreen.name -> HomeScreen
                CountriesDetail.name -> CountriesDetail
                null -> HomeScreen
                else -> throw IllegalArgumentException("Route $route is not recognised")
            }
    }

}