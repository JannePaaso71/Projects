package com.example.weatherforecast.model

import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query


//Defines the base URL for all API requests to OpenWeatherMap. All endpoints will be relative to this base URL.
private const val BASE_URL = "https://api.openweathermap.org/data/2.5/"


/*
* This school assignment was done by OUAS student Janne Paaso
* Interface WeatherAPI is an interface that Retrofit uses to generate an implementation for making network requests.
* */

interface WeatherAPI {
    @GET("weather")
    suspend fun getWeather( //Declares a suspend function, which allows it to be called within a coroutine without blocking the thread.
        @Query("appid") apiKey: String,
        @Query("q") city: String,
        @Query("units") units: String = "metric"
    ): Response<WeatherInfo>

    /*
    * Companion Object: Allows static-like access to members within the class.
    * It's used here to implement the Singleton pattern for WeatherAPI.
    * */

    companion object {
        private var weatherService: WeatherAPI? = null  //A private nullable variable that will hold the singleton instance of WeatherAPI.

        fun getInstance(): WeatherAPI {
            if(weatherService == null) {
                weatherService = Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build().create(WeatherAPI::class.java)
            }
            return weatherService!! //Returns the non-null weatherService instance.
                                    // If weatherService is actually null at this point, using !! will throw a NullPointerException.
        }
    }
}

/*
*Summary
Purpose of the Code:

Defines an interface WeatherAPI for making network requests to the OpenWeatherMap API using Retrofit.
Implements a singleton pattern to manage the Retrofit instance efficiently.
Key Components:

Retrofit Interface: Specifies the HTTP method, endpoint, and parameters for the API call.
Suspend Function: Allows asynchronous execution of network requests.
Companion Object and Singleton Pattern: Ensures only one instance of WeatherAPI is used throughout the app.
Usage Flow:

Obtain an instance of WeatherAPI via getInstance().
Call getWeather within a coroutine to fetch weather data.
Handle the response, updating the UI or handling errors as needed.
* */