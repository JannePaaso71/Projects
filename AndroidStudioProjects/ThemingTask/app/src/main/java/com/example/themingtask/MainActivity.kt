package com.example.themingtask

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.themingtask.ui.theme.MyTheme
import com.example.themingtask.ui.theme.ThemingTaskTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyTheme {
//                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
//                    MyApp()
//                }
                MyApp()
            }
        }
    }
}

@Composable
fun MyApp() {
    val appModifier = Modifier
        .fillMaxWidth()
        .padding(8.dp)
    Column (
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "My Title",
            style = MaterialTheme.typography.headlineSmall,
            modifier = appModifier
        )

        OutlinedTextField(
            value = "",
            onValueChange = { },
            modifier = appModifier
        )

        Button(
            onClick = { },
            modifier = appModifier
        ) {
            Text(text = "Submit")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MyAppPreview() {
    ThemingTaskTheme {
        MyApp()
    }
}










@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ThemingTaskTheme {
        Greeting("Android")
    }
}