plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
}

android {
    namespace = "com.example.marketrf"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.example.marketrf"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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
    buildFeatures{
        viewBinding = true
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)

// Para splash screen
    implementation(libs.androidx.core.splashscreen)

// Para reproducir videos de Youtube
    implementation(libs.androidyoutubeplayer.core)

//Para retrofit y Gson
    implementation(libs.retrofit)
    implementation(libs.converter.gson)

//Adicional para el interceptor
    implementation(libs.logging.interceptor)

//Glide y Picasso
    implementation(libs.glide)
    implementation(libs.picasso)

//Para las corrutinas con alcance lifecycle
    implementation(libs.androidx.lifecycle.runtime.ktx)

//Imágenes con bordes redondeados
    implementation(libs.roundedimageview)


    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}