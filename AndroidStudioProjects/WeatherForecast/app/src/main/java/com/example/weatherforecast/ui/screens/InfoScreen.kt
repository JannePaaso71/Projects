package com.example.weatherforecast.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.ui.text.style.TextAlign
import androidx.navigation.NavController


/*
* This school assignment was done by OUAS student Janne Paaso
* This code defines a composable function InfoScreen which represents a screen in an Android application built using Jetpack Compose.
* This screen displays information about the app and includes a top app bar with a back navigation button.
* */



@OptIn(ExperimentalMaterial3Api::class)  //An annotation indicating that the function uses experimental APIs from Material 3.
@Composable
fun InfoScreen(navController: NavController) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("About This App") },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {  //.popBackStack(): Navigates back to the previous screen in the navigation stack.
                        Icon(Icons.Filled.ArrowBack, contentDescription = "Back")
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
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "This weather application was made as part of an assignment for the OUAS mobile programming course, " +
                            "which can be used to retrieve current weather information from any city. " +
                            "The topic of the assignment was learning MVVM architecture, API integration and using Jetpack Compose.",
                    style = MaterialTheme.typography.bodyLarge,
                    textAlign = TextAlign.Center
                )
            }
        }
    )
}

/*
* The InfoScreen composable function defines a screen that displays information about the app.
* It includes a top app bar with a back navigation button and a centered text providing details about the app's purpose and the technologies used.
* The screen uses Jetpack Compose's Scaffold to structure the layout, and it adheres to the app's theming by utilizing MaterialTheme for consistent styling.
* Navigation is managed via the NavController, allowing the user to return to the previous screen seamlessly.
* */