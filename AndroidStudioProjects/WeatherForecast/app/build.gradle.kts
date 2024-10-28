import java.io.FileInputStream
import java.util.Properties

plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
}

android {
    namespace = "com.example.weatherforecast"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.weatherforecast"
        minSdk = 21
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        // Load local.properties
        val localProperties = Properties()
        val localPropertiesFile = rootProject.file("local.properties")
        if (localPropertiesFile.exists()) {
            localProperties.load(FileInputStream(localPropertiesFile))
        } else {
            println("local.properties file not found")
        }

        // Retrieve the API key
        val weatherApiKey = localProperties.getProperty("WEATHER_API_KEY")
        if (weatherApiKey == null || weatherApiKey.isEmpty()) {
            println("WEATHER_API_KEY not found in local.properties")
        }

        // Set the buildConfigField with the API key
        buildConfigField("String", "WEATHER_API_KEY", "\"$weatherApiKey\"")

        //buildConfigField("String", "WEATHER_API_KEY", "\"${project.properties["WEATHER_API_KEY"]}\"")

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
    buildFeatures {
        compose = true
        buildConfig = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.1"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {
    // Core libraries
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)

    // Jetpack Compose
    implementation(platform(libs.androidx.compose.bom))
    implementation("androidx.compose.ui:ui")
    implementation("androidx.compose.ui:ui-tooling-preview")
    implementation(libs.androidx.material3)

    // ViewModel for Compose
    implementation("androidx.lifecycle:lifecycle-viewmodel-compose:2.6.1")
    implementation("androidx.compose.runtime:runtime-livedata:1.4.3")  // LiveData support in Compose

    // Retrofit and Gson for API
    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    implementation("com.squareup.retrofit2:converter-gson:2.9.0")

    // Coroutines for asynchronous tasks
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.6.4")

    // Coil for image loading
    implementation("io.coil-kt:coil-compose:2.4.0")

    // Jetpack Navigation Compose
    implementation("androidx.navigation:navigation-compose:2.6.0")

    // Test dependencies
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)
}