package com.example.weatherforecast.ui.screens

import androidx.compose.foundation.layout.* // for layout
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.* // Use Material 3 components only
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import com.example.weatherforecast.viewmodel.WeatherViewModel
import com.example.weatherforecast.R
import com.example.weatherforecast.BuildConfig
import androidx.compose.runtime.livedata.observeAsState


/*
* This school assignment was done by OUAS student Janne Paaso
* This code defines a composable function WeatherScreen which is part of an Android application built using Jetpack Compose.
* The function represents the main screen of a weather forecasting app,
* where users can input a city name and retrieve current weather information.
* */

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WeatherScreen(viewModel: WeatherViewModel, onInfoClick: () -> Unit) {
    var city by remember { mutableStateOf("") }
    val weatherData by viewModel.weatherData.observeAsState()
    val isLoading by viewModel.isLoading.observeAsState(initial = false)
    val errorMessage by viewModel.errorMessage.observeAsState()

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Weather App") },
                actions = {
                    IconButton(onClick = { onInfoClick() }) {
                        Icon(Icons.Filled.Info, contentDescription = "Info")
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary,
                    titleContentColor = MaterialTheme.colorScheme.onPrimary,
                    actionIconContentColor = MaterialTheme.colorScheme.onPrimary
                )
            )
        },
        content = { padding ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(padding)
                    .padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Top
            ) {
                OutlinedTextField(
                    value = city,
                    onValueChange = { city = it },
                    label = { Text(stringResource(R.string.search_hint)) },
                    modifier = Modifier.fillMaxWidth(),
                    keyboardOptions = KeyboardOptions.Default.copy(
                        imeAction = ImeAction.Done
                    )
                )

                Spacer(modifier = Modifier.height(8.dp))

                Button(
                    onClick = {
                        if (city.isNotBlank()) {
                            viewModel.getWeather(city, BuildConfig.WEATHER_API_KEY)
                        }
                    },
                    modifier = Modifier.align(Alignment.End)
                ) {
                    Text(stringResource(R.string.get_weather))
                }

                Spacer(modifier = Modifier.height(16.dp))

                when {
                    isLoading -> {
                        CircularProgressIndicator()
                    }
                    errorMessage != null -> {
                        Text(
                            text = errorMessage ?: "",
                            color = MaterialTheme.colorScheme.error,
                            style = MaterialTheme.typography.bodyLarge
                        )
                    }
                    weatherData != null -> {
                        WeatherInfo(weatherData!!)
                    }
                }
            }
        }
    )
}

/*
* Putting it all together, the WeatherScreen function provides a user interface that allows users to:
Input a city name.
Trigger a weather data fetch for the entered city.
View a loading indicator while data is being fetched.
See an error message if something goes wrong.
View the fetched weather data when it becomes available.
* */