package com.example.weatherforecast.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.weatherforecast.model.WeatherInfo


/*
* This school assignment was done by OUAS student Janne Paaso
* This code defines a composable function named WeatherInfo, which displays weather information on the screen using Jetpack Compose.
* The function takes a WeatherInfo object as a parameter and uses it to display various weather details such as the city name, temperature, humidity, wind speed, and a description.
* */

@Composable
fun WeatherInfo(weatherInfo: WeatherInfo) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "City: ${weatherInfo.name}",
            style = MaterialTheme.typography.headlineSmall
        )
        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = "Temperature: ${weatherInfo.main.temp}°C",
            style = MaterialTheme.typography.bodyLarge
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = "Humidity: ${weatherInfo.main.humidity}%",
            style = MaterialTheme.typography.bodyLarge
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = "Wind Speed: ${weatherInfo.wind.speed} m/s",
            style = MaterialTheme.typography.bodyLarge
        )

        Spacer(modifier = Modifier.height(8.dp))

        weatherInfo.weather.firstOrNull()?.let { weather ->
            Text(
                text = "Description: ${weather.description}",
                style = MaterialTheme.typography.bodyLarge
            )
        }
    }
}