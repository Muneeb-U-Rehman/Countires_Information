package com.example.countiresinformation.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import coil.compose.rememberImagePainter
import com.example.countiresinformation.model.CountriesDataModel
import com.example.countiresinformation.nav.countriesNavigation
import com.example.countiresinformation.viewmodel.CountriesDataViewModel
import com.google.gson.Gson

@Composable
fun HomeScreen(navController: NavController, viewModel: CountriesDataViewModel) {

    MyApp(navController = navController, viewModel = viewModel)

}

@Composable
fun MyApp(navController: NavController,viewModel: CountriesDataViewModel) {
    MaterialTheme {
        CardExample(viewModel)
    }
}

@Composable
fun CardExample(viewModel: CountriesDataViewModel) {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        CardDesign(viewModel)
    }
}


@Composable
fun CardDesign(viewModel: CountriesDataViewModel) {
    val navController = rememberNavController()

    val list= remember {
        mutableStateListOf<CountriesDataModel>()
    }
    LaunchedEffect(key1 = true, block ={
        list.addAll(viewModel.fetchData())
    })
    LazyColumn(content = {
        items(list){item->
            Card(
                modifier = Modifier
                    .padding(14.dp)
                    .fillMaxWidth(),

                shape = RoundedCornerShape(8.dp),
                elevation = CardDefaults.cardElevation(
                    defaultElevation = 10.dp
                )
            ) {
                Row(
                    modifier = Modifier
                        .padding(14.dp)
                ) {
                    Image(
                        painter = rememberImagePainter(data = item.flags?.png), // Replace with your image resource
                        contentDescription = null,
                        modifier = Modifier
                            .size(70.dp)
                            .clip(RoundedCornerShape(8.dp))
                    )

                    Spacer(modifier = Modifier.width(10.dp))

                    Column(
                        modifier = Modifier.weight(1f),
                        verticalArrangement = Arrangement.Center
                    ) {
                        item.name?.common?.let {
                            Text(
                                text = it,
                                fontSize = 20.sp,
                                fontWeight = FontWeight.Bold
                            )
                        }

                        Spacer(modifier = Modifier.height(8.dp))

                        Text(
                            text = item.name?.official.toString(),
                            fontSize = 14.sp
                        )
                    }

                    Spacer(modifier = Modifier.width(10.dp))

                    Button(
                        onClick = {

                            // Serialize the object to JSON and navigate to the destination screen

                            val myObjectJson = Gson().toJson(item)
                            val myData = myObjectJson.toString()

                            navController.navigate(CountriesScreens.CountriesDetail.name+"/$myData")

                            try{
                                if (myData!= null){
                                    navController.navigate("CountriesDetail/$myData")
                                }
                            }
                            catch (e:Exception){
                                e.message
                            }
                        },
                        modifier = Modifier
                            .align(Alignment.CenterVertically)
                    ) {
                        Text(text = "Button")
                    }
                }
            }
        }
    }
    )
}
