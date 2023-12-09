package com.rahmadev.hamba.core.data.source.network.retrofit

import com.rahmadev.hamba.core.data.source.network.response.DoaResponseItem
import retrofit2.http.GET

interface DoaApiService {

    @GET("doa")
    suspend fun getDoa(): List<DoaResponseItem>
}