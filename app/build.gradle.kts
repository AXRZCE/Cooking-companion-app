plugins {
    alias(libs.plugins.android.application)
}

android {
    namespace = "com.example.cookingcompanionapp"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.cookingcompanionapp"
        minSdk = 33
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
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    buildFeatures {
        viewBinding = true
    }
}

dependencies {

    dependencies {
        implementation(libs.appcompat) // AppCompat for backward compatibility
        implementation(libs.material) // Material Design components
        implementation(libs.constraintlayout) // ConstraintLayout for flexible UI design
        implementation(libs.lifecycle.livedata.ktx) // LiveData for observing data changes
        implementation(libs.lifecycle.viewmodel.ktx) // ViewModel for managing UI-related data
        implementation(libs.navigation.fragment) // Navigation Component for fragment navigation
        implementation(libs.navigation.ui) // Navigation UI Component for integrating with UI

        testImplementation(libs.junit) // JUnit for unit testing
        androidTestImplementation(libs.ext.junit) // JUnit extensions for Android testing
        androidTestImplementation(libs.espresso.core)
    }}

