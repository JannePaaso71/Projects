package com.example.heartratelimits

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.heartratelimits.ui.theme.HeartRateLimitsTheme
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.viewmodel.compose.viewModel


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            HeartRateLimitsTheme {
                HeartRateLimits()
            }
        }
    }
}

@Composable
fun HeartRateLimits(HrViewModel: HrViewModel = viewModel()) {

    Column(
        modifier = Modifier.padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        TextField(
            value = HrViewModel.ageInput,
            onValueChange = {HrViewModel.changeAgeInput(it)},
            label = { Text(text = "Enter your age")},
            singleLine = true,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )
        Text(
            text = stringResource(R.string.heart_rate_limits, HrViewModel.lower, HrViewModel.upper)
        )
    }
}

@Preview
@Composable
fun DefaultPreview() {
    HeartRateLimitsTheme {
        HeartRateLimits()
    }
}