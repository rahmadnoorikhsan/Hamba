import java.util.Properties

plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id("kotlin-kapt")
    id("dagger.hilt.android.plugin")
    id("kotlin-parcelize")
}

android {
    namespace = "com.rahmadev.hamba.core"
    compileSdk = 34

    defaultConfig {
        minSdk = 24

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")

        val properties = Properties()
        properties.load(project.rootProject.file("local.properties").inputStream())

        buildConfigField("String", "BASE_URL_HADIST", "\"${properties.getProperty("BASE_URL_HADIST")}\"")
        buildConfigField("String", "BASE_URL_DOA", "\"${properties.getProperty("BASE_URL_DOA")}\"")
        buildConfigField("String", "BASE_URL_QURAN", "\"${properties.getProperty("BASE_URL_QURAN")}\"")
        buildConfigField("String", "BASE_URL_ALADHAN", "\"${properties.getProperty("BASE_URL_ALADHAN")}\"")
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

    buildFeatures {
        viewBinding = true
        buildConfig = true
    }
}

dependencies {

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

    //retrofit
    implementation(Dependencies.retrofit)
    implementation(Dependencies.converterGson)
    implementation(Dependencies.loggingInterceptor)

    //location
    implementation(Dependencies.location)
    implementation(Dependencies.maps)

    //prefs
    implementation(Dependencies.prefs)
}