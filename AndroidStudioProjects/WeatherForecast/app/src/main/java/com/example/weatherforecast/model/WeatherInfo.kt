package com.example.weatherforecast.model

/*
* This school assignment was done by OUAS student Janne Paaso
* The following data classes are used to map the JSON response from the OpenWeatherMap API to Kotlin objects.
* Each class corresponds to a part of the JSON structure.
* */

data class WeatherInfo(
    val main: Main,
    val weather: List<Weather>,
    val wind: Wind,
    val name: String
)

data class Main(
    val temp: Double,
    val humidity: Int
)

data class Weather(
    val description: String,
    val icon: String
)

data class Wind(
    val speed: Double
)

/*
* How These Classes Work Together
* JSON Mapping: When it makes a network request to the OpenWeatherMap API, it returns a JSON object containing various fields.
* These data classes are designed to match the structure of that JSON response.
* Deserialization: Libraries like Gson automatically deserialize the JSON into these Kotlin data classes.
* Usage:
* After making a successful API call, it receives a WeatherInfo object.
* It can access the temperature via weatherInfo.main.temp.
* Access humidity via weatherInfo.main.humidity.
* Get the weather description via weatherInfo.weather[0].description.
* Get the wind speed via weatherInfo.wind.speed.
* Get the city name via weatherInfo.name.
* */