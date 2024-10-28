package com.example.weatherforecast.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.weatherforecast.ui.screens.WeatherScreen
import com.example.weatherforecast.ui.screens.InfoScreen
import com.example.weatherforecast.viewmodel.WeatherViewModel


/*
* This school assignment was done by OUAS student Janne Paaso
* This code defines a navigation graph for an Android application using Jetpack Compose and the Navigation component.
* */

@Composable
fun SetupNavGraph(navController: NavHostController, viewModel: WeatherViewModel) {
    NavHost(navController = navController, startDestination = "weather") {
        composable("weather") {
            WeatherScreen(viewModel = viewModel, onInfoClick = {
                navController.navigate("info")
            })
        }
        composable("info") {
            InfoScreen(navController = navController)
        }
    }
}

/*
* How the Navigation Works
App Launches:

The NavHost starts at the "weather" route, as specified by startDestination.
The WeatherScreen is displayed.
User Interaction on WeatherScreen:

The user interacts with the WeatherScreen.
When the user clicks the Info button (handled via onInfoClick), the following occurs:
navController.navigate("info") is called.
The navigation controller changes the current route to "info".
Navigating to InfoScreen:

The NavHost detects the route change to "info" and displays the corresponding composable.
The InfoScreen is displayed.
The InfoScreen can use the navController to navigate back or to other destinations if needed.
Returning to WeatherScreen:

If the InfoScreen includes a back button that calls navController.popBackStack(), the navigation controller pops the current route off the back stack.
The app navigates back to the previous route, which is "weather".
* */