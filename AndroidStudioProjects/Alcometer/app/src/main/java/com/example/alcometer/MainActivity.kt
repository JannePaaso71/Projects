package com.example.alcometer

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.unit.toSize
import com.example.alcometer.ui.theme.AlcometerTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AlcometerTheme {
                    AlcometerScreen()
            }
        }
    }
}

@Composable
fun Heading(title: String) {
    Text(
        text = title,
        fontSize = 24.sp,
        textAlign = TextAlign.Center,
        color = MaterialTheme.colorScheme.primary,
        style = MaterialTheme.typography.headlineMedium,
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 16.dp)
    )
}

@Composable
fun WeightField(weightInput: String, onValueChange: (String) -> Unit) {
    OutlinedTextField(
        value = weightInput,
        onValueChange = onValueChange,
        label = { Text(text = "Enter your weight in kg") },
        singleLine = true,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
        modifier = Modifier.fillMaxWidth()
    )
}

@Composable
fun AlcometerScreen() {
    var weightInput by remember { mutableStateOf("") }
    var male by remember { mutableStateOf(true) }
    var bottles by remember { mutableStateOf(0f) }
    var hours by remember { mutableStateOf(0f) }

    Column(
        modifier = Modifier.padding(8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
    ) {
        Heading(title = stringResource(R.string.alcometer))
        WeightField(weightInput = weightInput, onValueChange = { weightInput = it })
        GenderChoices(male = male, setGenderMale = { male = it})
        AmountOfBottle(onClick = { bottles = it })
        AmountOfHour(onClick = { hours = it })

        val weight = weightInput.toFloatOrNull() ?: 0.0f
        if (weight > 0) {
            ResultOfAlcometer(weight = weight, bottles = bottles, hours = hours, male = male)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun AlcometerScreenPreview() {
    AlcometerTheme {
        AlcometerScreen()
    }
}

@Composable
fun GenderChoices(male: Boolean, setGenderMale: (Boolean) -> Unit) {
    Column(Modifier.selectableGroup())  {
        Row(verticalAlignment = Alignment.CenterVertically) {
            RadioButton(
                selected = male,
                onClick = { setGenderMale(true) }
            )
            Text(text = "Male")
        }
        Row(verticalAlignment = Alignment.CenterVertically) {
            RadioButton(
                selected = !male,
                onClick = { setGenderMale(false) }
            )
            Text(text = "Female")
        }
    }
}

@Composable
fun AmountOfBottle(onClick: (Float) -> Unit) {
    var expanded by remember { mutableStateOf(false) }
    var amountOfBottle by remember { mutableStateOf("0") }
    var textFieldSize by remember { mutableStateOf(Size.Zero) }
    val amount = listOf("0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10")

    val icon = if (expanded)
        Icons.Filled.KeyboardArrowUp
    else
        Icons.Filled.KeyboardArrowDown

    Column {
        OutlinedTextField(
            readOnly = true,
            value = amountOfBottle,
            onValueChange = { amountOfBottle = it },
            modifier = Modifier
                .fillMaxWidth()
                .onGloballyPositioned { coordinates ->
                    textFieldSize = coordinates.size.toSize()
                },
            label = {Text("Select amount of bottle")},
            trailingIcon = {
                IconButton(onClick = { expanded = !expanded }) {
                    androidx.compose.material3.Icon(
                        imageVector = icon,
                        contentDescription = "Expand/Collapse dropdown",
                    )
                }
            }
        )
        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false },
            modifier = Modifier
                .width(with(LocalDensity.current) { textFieldSize.width.toDp()})
        ) {
                    amount.forEach { label ->
                        DropdownMenuItem(
                            text = { Text(text = label) },
                            onClick = {
                            amountOfBottle = label

                                val intensity: Float = when (label) {
                                    "1" -> 1.0f
                                    "2" -> 2.0f
                                    "3" -> 3.0f
                                    "4" -> 4.0f
                                    "5" -> 5.0f
                                    else -> 0.0f
                                }
                            onClick(intensity)
                            expanded = false
                        })
                    }}
    }
}

@Composable
fun AmountOfHour(onClick: (Float) -> Unit) {
    var expanded by remember { mutableStateOf(false) }
    var amountOfHour by remember { mutableStateOf("0") }
    var textFieldSize by remember { mutableStateOf(Size.Zero) }
    val amount = listOf("0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10")

    val icon = if (expanded)
        Icons.Filled.KeyboardArrowUp
    else
        Icons.Filled.KeyboardArrowDown

    Column {
        OutlinedTextField(
            readOnly = true,
            value = amountOfHour,
            onValueChange = { amountOfHour = it },
            modifier = Modifier
                .fillMaxWidth()
                .onGloballyPositioned { coordinates ->
                    textFieldSize = coordinates.size.toSize()
                },
            label = {Text("Select amount of hour")},
            trailingIcon = {
                IconButton(onClick = { expanded = !expanded }) {
                    androidx.compose.material3.Icon(
                        imageVector = icon,
                        contentDescription = "Expand/Collapse dropdown",
                    )
                }
            }
        )
        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false },
            modifier = Modifier
                .width(with(LocalDensity.current) { textFieldSize.width.toDp()})
        ) {
            amount.forEach { label ->
                DropdownMenuItem(
                    text = { Text(text = label) },
                    onClick = {
                        amountOfHour = label

                        val intensity: Float = when (label) {
                            "1" -> 1.0f
                            "2" -> 2.0f
                            "3" -> 3.0f
                            "4" -> 4.0f
                            "5" -> 5.0f
                            else -> 0.0f
                        }
                        onClick(intensity)
                        expanded = false
                    })
            }}
    }
}

@Composable
fun ResultOfAlcometer(weight: Float, bottles: Float, hours: Float, male: Boolean) {
    val alcoholDistributionRatio = if (male) 0.7 else 0.6
    val gramsPerBottle = 4.5f
    val metabolismRatePerHour = 0.015f
    val totalAlcoholInGrams = bottles * gramsPerBottle
    val bac = (totalAlcoholInGrams * 5.14f) / (weight * alcoholDistributionRatio) - (metabolismRatePerHour * hours)

    // If BAC is less than zero, set it to zero
    val finalBac = if (bac < 0) 0f else bac

    // Display the result
    Column(modifier = Modifier.padding(16.dp)) {
        Text(
            text = "Estimated Blood Alcohol Content (BAC): %.3f".format(finalBac),
            fontSize = 18.sp,
            color = MaterialTheme.colorScheme.primary
        )
    }
}

