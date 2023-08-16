package com.example.countiresinformation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import com.example.countiresinformation.nav.countriesNavigation
import com.example.countiresinformation.viewmodel.CountriesDataViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        val viewModel: CountriesDataViewModel by viewModels()
        setContent {

            MyApp {
                countriesNavigation(viewModel)
            }
        }
    }
}

@Composable
fun MyApp(content: @Composable () -> Unit) {

    MaterialTheme {
        content()
    }
}



