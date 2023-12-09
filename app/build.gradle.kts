plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("kotlin-kapt")
    id("dagger.hilt.android.plugin")
    id("androidx.navigation.safeargs")
}

android {
    namespace = "com.rahmadev.hamba"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.rahmadev.hamba"
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
    implementation(project(Modules.home))
    implementation(project(Modules.compass))
    implementation(project(Modules.quran))

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

    //splash-api
    implementation(Dependencies.splash)

    //prefs
    implementation(Dependencies.prefs)
}