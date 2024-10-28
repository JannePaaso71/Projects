package com.example.weatherforecast.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.weatherforecast.repository.WeatherRepository


/*
* This school assignment was done by OUAS student Janne Paaso
* This code defines a WeatherViewModelFactory class,
* which is used to create instances of WeatherViewModel in an Android application using the MVVM architecture.
* The factory ensures that the WeatherViewModel is instantiated with the required WeatherRepository dependency.
* */

class WeatherViewModelFactory(val repository: WeatherRepository): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(WeatherViewModel::class.java)) {
            return WeatherViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}


/*
* WeatherViewModelFactory:
* A factory class that implements ViewModelProvider.Factory.
* Used to create instances of WeatherViewModel with the required WeatherRepository dependency.
*
* Key Function:
* create: Overrides the create method to provide custom instantiation logic for WeatherViewModel.
*
* Usage Scenario:
* When a ViewModel requires constructor parameters, a factory is needed to supply those dependencies during creation.
*
* Implementation Details:
* Checks if the requested modelClass is WeatherViewModel.
* Creates and returns a new instance of WeatherViewModel with the repository.
* Throws an exception if an unknown ViewModel class is requested.
* */