package com.example.countiresinformation.nav

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navArgument
import androidx.navigation.compose.rememberNavController
import com.example.countiresinformation.model.CountriesDataModel
import com.example.countiresinformation.screens.CountriesDetail
import com.example.countiresinformation.screens.CountriesScreens
import com.example.countiresinformation.screens.HomeScreen
import com.example.countiresinformation.viewmodel.CountriesDataViewModel
import com.google.gson.Gson
import com.google.gson.JsonObject
import org.json.JSONObject

@Composable
fun countriesNavigation(viewModel:CountriesDataViewModel) {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = CountriesScreens.HomeScreen.name
    ) {
        composable(route = CountriesScreens.HomeScreen.name) {
            HomeScreen(navController,viewModel)
        }
        composable(CountriesScreens.CountriesDetail.name+"/{myData}",
            arguments = listOf(navArgument(name = "myData") {type = NavType.StringType})){
                backStackEntry ->
            CountriesDetail(navController = navController, Gson().fromJson(backStackEntry.arguments?.getString("myData"), CountriesDataModel::class.java))
        }
        }

    }

