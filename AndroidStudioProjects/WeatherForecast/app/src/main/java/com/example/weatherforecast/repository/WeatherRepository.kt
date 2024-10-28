package com.example.weatherforecast.repository

import com.example.weatherforecast.model.WeatherAPI
import com.example.weatherforecast.model.WeatherInfo
import retrofit2.Response


/*
* This school assignment was done by OUAS student Janne Paaso
*  This code defines a WeatherRepository class that serves as a repository in an MVVM architecture.
* */

class WeatherRepository(private val apiService: WeatherAPI) {
    suspend fun getWeather(city: String, apiKey: String): Response<WeatherInfo> {
        return apiService.getWeather(apiKey, city)
    }
}

/*
* WeatherRepository Class:

Acts as a data provider for weather information.
Delegates network requests to the WeatherAPI.
Keeps the ViewModel and UI decoupled from the details of data retrieval.
Integration in MVVM Architecture:

Fits within the Model layer, providing data to the ViewModel.
Promotes clean architecture principles and enhances the scalability of the app.
* */
