plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
    alias(libs.plugins.hilt.plugin)
    alias(libs.plugins.kotlin.serialization)
    alias(libs.plugins.ksp)
}

android {
    namespace = "com.asantivanezg.paginationexercise"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.asantivanezg.paginationexercise"
        minSdk = 24
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
        debug {
            val baseUrl = "https://api.themoviedb.org"
            buildConfigField("String", "BASE_URL", "\"$baseUrl\"")
            val token = "eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiJiZjA0NDYwMmY3YjAwZjhiMDE2MGMyZTFmYTViMTZjNiIsIm5iZiI6MTU0OTA2MDc0Ni44NDUsInN1YiI6IjVjNTRjYThhYzNhMzY4MGI1Nzg0NDRjOSIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.D_w_Yb4TOLRYlS_onBW4k8AXBrtuiNZWKbb6iGVp3II"
            buildConfigField("String", "TOKEN", "\"$token\"")
            val apiKey = "bf044602f7b00f8b0160c2e1fa5b16c6"
            buildConfigField("String", "API_KEY", "\"$apiKey\"")
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
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)
    implementation(libs.androidx.navigation.compose)
    implementation(libs.androidx.lifecycle.viewModel.compose)
    implementation(libs.androidx.lifecycle.runtime.compose)

    // coil
    implementation(libs.coil)
    implementation(libs.coil.okhttp)

    // retrofit
    implementation(libs.retrofit)
    implementation(libs.okhttp)
    implementation(libs.okhttp.logging)
    implementation(libs.gson)
    implementation(libs.gson.converter)

    // room
    implementation(libs.room.runtime)
    implementation(libs.room.ktx)
    implementation(libs.room.paging)
    ksp(libs.room.compiler)

    // hilt
    implementation(libs.hilt.android)
    implementation(libs.hilt.navigation.android)
    ksp(libs.hilt.kpt)

    // paging3
    implementation(libs.paging)
    implementation(libs.paging.runtime)

    implementation(libs.kotlin.coroutine)
    implementation(libs.kotlin.serialization.json)

    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)
}