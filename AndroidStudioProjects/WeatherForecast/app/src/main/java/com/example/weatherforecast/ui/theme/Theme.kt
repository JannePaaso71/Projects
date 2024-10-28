package com.example.weatherforecast.ui.theme

import android.R.id.primary
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext


private val DarkColorScheme = darkColorScheme(
    primary = Orange80,
    onPrimary = OnPrimaryDark,
    secondary = Teal80,
    onSecondary = Color.White,
    tertiary = Gray80,
    background = Color(0xFF121212),
    onBackground = Color.White,
    surface = Color(0xFF1E1E1E),
    onSurface = Color.White,
    error = Color(0xFFCF6679),
    onError = Color.Black
)

private val LightColorScheme = lightColorScheme(
    primary = Orange40,
    onPrimary = OnPrimaryLight,
    secondary = Teal40,
    onSecondary = Color.Black,
    tertiary = Gray40,
    background = Color.White,
    onBackground = Color.Black,
    surface = Color(0xFFF5F5F5),
    onSurface = Color.Black,
    error = Color(0xFFB00020),
    onError = Color.White
)

@Composable
fun WeatherForecastTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    dynamicColor: Boolean = false,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }

        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}
