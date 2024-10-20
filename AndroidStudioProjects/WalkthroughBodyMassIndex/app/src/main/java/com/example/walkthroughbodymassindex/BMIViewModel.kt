package com.example.walkthroughbodymassindex

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.lifecycle.ViewModel

class BMIViewModel: ViewModel() {
    var heightInput: String by mutableStateOf("")
    var weightInput: String by mutableStateOf("")

    private val height: Float
        get() = heightInput.toFloatOrNull()?.div(100) ?: 0.0f

    private val weight: Float
        get() = weightInput.toFloatOrNull() ?: 0.0f

    private val bmi: Double
        get() = if (weight > 0f && height > 0f) {
            (weight / (height * height).toDouble())
        } else 0.0

    fun changeHeightInput(value: String) {
        heightInput = value
    }

    fun changeWeightInput(value: String) {
        weightInput = value
    }

    fun calculateBmi(): Double {
        return bmi

    }
}
