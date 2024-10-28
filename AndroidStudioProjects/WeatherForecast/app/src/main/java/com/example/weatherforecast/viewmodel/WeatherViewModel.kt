package com.example.weatherforecast.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.weatherforecast.BuildConfig
import com.example.weatherforecast.model.WeatherInfo
import com.example.weatherforecast.repository.WeatherRepository
import kotlinx.coroutines.launch


/*
* This school assignment was done by OUAS student Janne Paaso
* This code defines a WeatherViewModel class,
* which is part of the Model-View-ViewModel (MVVM) architecture in an Android application.
* The ViewModel interacts with the repository to fetch weather data from an API and exposes this data to the UI through LiveData.
* It also handles loading states and error messages.
* */

class WeatherViewModel (private val repository: WeatherRepository) : ViewModel() {
    private val _weatherData = MutableLiveData<WeatherInfo?>()
    val weatherData: LiveData<WeatherInfo?> = _weatherData

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> = _isLoading

    private val _errorMessage = MutableLiveData<String?>()
    val errorMessage: LiveData<String?> = _errorMessage

    fun getWeather(city: String, apiKey: String) {
        _isLoading.value = true
        viewModelScope.launch {
            try {
                val apiKey = BuildConfig.WEATHER_API_KEY
                //Log the API key
                Log.d("WeatherViewModel", "Using API Key: $apiKey")

                if (apiKey.isNullOrEmpty()) {
                    _errorMessage.value = "API key is missing. Please check your configuration."
                    _isLoading.value = false
                    return@launch
                }

                val response = repository.getWeather(city, apiKey)
                if (response.isSuccessful) {
                    _weatherData.value = response.body()
                    _errorMessage.value = null
                    //Log response details
                    Log.d("WeatherViewModel", "Response Code: ${response.code()}")
                    Log.d("WeatherViewModel", "Response Message: ${response.message()}")
                    Log.d("WeatherViewModel", "Response Headers: ${response.headers()}")
                    Log.d("WeatherViewModel", "Weather data fetched successfully: ${response.body()}")
                } else {
                    // Log the error body for more details
                    val errorBody = response.errorBody()?.string()
                    Log.e("WeatherViewModel", "Error Body: $errorBody")

                    if (response.code() == 401) {
                        _errorMessage.value = "Unauthorized. Please check your API key."
                    } else {
                        _errorMessage.value = "Error: ${response.code()} ${response.message()}"
                    }
                    _weatherData.value = null
                    //Log error details
                    Log.e("WeatherViewModel", "API Error: ${response.code()} ${response.message()}")
                }
            } catch (e: Exception) {
                _errorMessage.value = "Failed to load data: ${e.message}"
                _weatherData.value = null
                //Log exception details
                Log.e("WeatherViewModel", "Exception: ${e.localizedMessage}", e)
            } finally {
                _isLoading.value = false
            }
        }
    }
}


/*
* The WeatherViewModel class is responsible for fetching weather data from the repository
* and managing the UI state in an Android application using MVVM architecture.
* It uses LiveData to expose data and loading/error states to the UI, allowing for reactive updates.
* The use of coroutines and proper error handling ensures that network requests are performed efficiently
* and that the application remains responsive.
* */