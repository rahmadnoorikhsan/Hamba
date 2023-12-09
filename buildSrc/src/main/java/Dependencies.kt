object Dependencies {
    val coreKtx by lazy { "androidx.core:core-ktx:${Versions.coreKtx}" }
    val appCompat by lazy { "androidx.appcompat:appcompat:${Versions.appCompat}" }
    val materialDesign by lazy { "com.google.android.material:material:${Versions.materialDesign}" }
    val constraintLayout by lazy { "androidx.constraintlayout:constraintlayout:${Versions.constraintLayout}" }
    val junit by lazy { "junit:junit:${Versions.junit}" }
    val extJunit by lazy { "androidx.test.ext:junit:${Versions.extJunit}" }
    val esspresso by lazy { "androidx.test.espresso:espresso-core:${Versions.esspresso}" }
    val daggerHilt by lazy { "com.google.dagger:hilt-android:${Versions.daggerHilt}" }
    val hiltCompiler by lazy { "androidx.hilt:hilt-compiler:${Versions.hiltCompiler}" }
    val daggerHiltCompiler by lazy { "com.google.dagger:hilt-android-compiler:${Versions.daggerHilt}" }
    val navigationKtx by lazy { "androidx.navigation:navigation-fragment-ktx:${Versions.navigationKtx}" }
    val navigationUiKtx by lazy { "androidx.navigation:navigation-ui-ktx:${Versions.navigationKtx}" }
    val retrofit by lazy { "com.squareup.retrofit2:retrofit:${Versions.retrofit}" }
    val converterGson by lazy { "com.squareup.retrofit2:converter-gson:${Versions.retrofit}" }
    val loggingInterceptor by lazy { "com.squareup.okhttp3:logging-interceptor:${Versions.loggingInterceptor}" }
    val viewModel by lazy { "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.lifecycle}" }
    val liveData by lazy { "androidx.lifecycle:lifecycle-livedata-ktx:${Versions.lifecycle}" }
    val location by lazy { "com.google.android.gms:play-services-location:${Versions.location}" }
    val splash by lazy { "androidx.core:core-splashscreen:${Versions.splashApi}" }
    val maps by lazy { "com.google.android.gms:play-services-maps:${Versions.maps}" }
    val prefs by lazy {"com.pixplicity.easyprefs:EasyPrefs:${Versions.prefs}"}
}