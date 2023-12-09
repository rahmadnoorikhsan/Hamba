package com.rahmadev.hamba.core.data.source.network.retrofit

import com.rahmadev.hamba.core.data.source.network.response.HadithResponse
import retrofit2.http.GET

interface HadithApiService {

    @GET("hadith/bukhari")
    suspend fun getHadith(): HadithResponse
}