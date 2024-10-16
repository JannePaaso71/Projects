package com.example.simplenavigation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavType
import androidx.navigation.compose.rememberNavController
import com.example.simplenavigation.ui.theme.SimpleNavigationTheme
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SimpleNavigationTheme {
                NavigationExampleApp()

            }
        }
    }
}

@Composable
fun HomeScreen(navController: NavController) {
    var text by remember { mutableStateOf("") }
    Column (
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
            Text(text = "Home Screen")
            OutlinedTextField(
                value = text,
                onValueChange = { text = it },
                label = { Text("Label") }
            )
            Button(
                onClick = { navController.navigate("second/$text") },
                enabled = text.isNotEmpty()
            ) {
                Text(text = "Go to Second Screen")
            }
    }
}

@Composable
fun SecondScreen(navController: NavController, parameter: String) {
    Column (
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text(text = "Second Screen")
        Text(text = "Parameter: $parameter")
        Button(
            onClick = { navController.navigateUp() }
            ) {
            Text(text = "Go back to Home Screen")
        }
    }
}


@Composable
fun NavigationExampleApp() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = "home"
    ) {
        composable("home") {
            HomeScreen(navController)
        }
        composable("second/{parameter}",
            arguments = listOf(
                navArgument("parameter") {
                    type = NavType.StringType
                }
            )
        ) {
            val parameter = it.arguments?.getString("parameter")!!
            SecondScreen(
                navController = navController,
                parameter = parameter
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    SimpleNavigationTheme {
        HomeScreen( rememberNavController())
    }
}