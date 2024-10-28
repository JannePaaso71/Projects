package com.example.weatherforecast

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.weatherforecast.ui.theme.WeatherForecastTheme
import androidx.compose.material3.MaterialTheme
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.rememberNavController
import com.example.weatherforecast.model.WeatherAPI
import com.example.weatherforecast.navigation.SetupNavGraph
import com.example.weatherforecast.repository.WeatherRepository
import com.example.weatherforecast.ui.screens.WeatherScreen
import com.example.weatherforecast.viewmodel.WeatherViewModel
import com.example.weatherforecast.viewmodel.WeatherViewModelFactory

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WeatherForecastTheme {
                Surface(color = MaterialTheme.colorScheme.background) {
                    val navController = rememberNavController()
                    val apiService = WeatherAPI.getInstance()
                    val repository = WeatherRepository(apiService)
                    val viewModelFactory = WeatherViewModelFactory(repository)
                    val viewModel: WeatherViewModel = viewModel(factory = viewModelFactory)
                    SetupNavGraph(navController = navController, viewModel = viewModel)
                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun WeatherForecastPreview() {
    WeatherForecastTheme {
        val apiService = WeatherAPI.getInstance()
        val repository = WeatherRepository(apiService)
        val viewModelFactory = WeatherViewModelFactory(repository)
        val viewModel: WeatherViewModel = viewModel(factory = viewModelFactory)
        WeatherScreen(viewModel) {}
    }
}