package com.rahmadev.hamba.core.di

import com.rahmadev.hamba.core.BuildConfig
import com.rahmadev.hamba.core.data.source.network.retrofit.AladhanApiService
import com.rahmadev.hamba.core.data.source.network.retrofit.DoaApiService
import com.rahmadev.hamba.core.data.source.network.retrofit.HadithApiService
import com.rahmadev.hamba.core.data.source.network.retrofit.QuranApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @Singleton
    fun provideOkHttpClient(): OkHttpClient {
        return OkHttpClient.Builder()
            .build()
    }

    @Provides
    @Singleton
    fun provideAladhanApiService(okHttpClient: OkHttpClient): AladhanApiService {
        return Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_URL_ALADHAN)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()
            .create()
    }

    @Provides
    @Singleton
    fun provideHadithApiService(okHttpClient: OkHttpClient): HadithApiService {
        return Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_URL_HADIST)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()
            .create()
    }

    @Provides
    @Singleton
    fun provideDoaApiService(okHttpClient: OkHttpClient): DoaApiService {
        return Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_URL_DOA)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()
            .create()
    }

    @Provides
    @Singleton
    fun provideQuranApiService(okHttpClient: OkHttpClient): QuranApiService {
        return Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_URL_QURAN)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()
            .create()
    }
}