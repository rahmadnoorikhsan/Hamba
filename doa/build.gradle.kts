plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id("kotlin-kapt")
    id("dagger.hilt.android.plugin")
    id("androidx.navigation.safeargs")
}

android {
    namespace = "com.rahmadev.hamba.doa"
    compileSdk = 34

    defaultConfig {
        minSdk = 24

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
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
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
    viewBinding {
        enable = true
    }
}

dependencies {

    implementation(project(Modules.core))

    implementation(Dependencies.coreKtx)
    implementation(Dependencies.appCompat)

    //ui
    implementation(Dependencies.materialDesign)
    implementation(Dependencies.constraintLayout)

    //testing
    testImplementation(Dependencies.junit)
    androidTestImplementation(Dependencies.extJunit)
    androidTestImplementation(Dependencies.esspresso)

    //dagger-hilt
    implementation(Dependencies.daggerHilt)
    kapt(Dependencies.hiltCompiler)
    kapt(Dependencies.daggerHiltCompiler)

    //navigation
    implementation(Dependencies.navigationKtx)
    implementation(Dependencies.navigationUiKtx)

    //lifecycle
    implementation(Dependencies.viewModel)
    implementation(Dependencies.liveData)
}