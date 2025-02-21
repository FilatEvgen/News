plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kapt)
    alias(libs.plugins.hilt)
}

android {
    namespace = "ru.kosproger.news"
    compileSdk = 35

    defaultConfig {
        applicationId = "ru.kosproger.news"
        minSdk = 24
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }
    buildFeatures{
        viewBinding = true
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
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.androidx.material)
    implementation(libs.androidx.constraintlayout)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.navigation.ui.ktx)
    implementation(libs.androidx.navigation.fragment.ktx)
    implementation(libs.retrofit)
    implementation(libs.okhttp.logging.interceptor)
    implementation(libs.converter.gson)
    implementation(libs.javapoet)
    androidTestImplementation(libs.androidx.junit)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    //Hilt
    implementation(libs.hilt)
    kapt(libs.hiltCompiler)
    // Room
    implementation(libs.androidx.room.runtime)
    implementation(libs.androidx.room.ktx)
    kapt(libs.androidx.room.compiler)
}