package com.example.heartratelimits

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class HrViewModel: ViewModel() {
    var ageInput by mutableStateOf("")

    var upper: Float = 0f
        get() {
            return calculate(0.85f)
        }
    var lower: Float = 0f
        get() {
            return calculate(0.65f)
        }

    private var age: Int = 0
        get() {
            return ageInput.toIntOrNull() ?: 0
        }

    fun changeAgeInput(input: String) {
        ageInput = input
    }

    private fun calculate(multiplier: Float): Float {
        return if (age > 0) (220 - age) * multiplier else 0f
    }
}