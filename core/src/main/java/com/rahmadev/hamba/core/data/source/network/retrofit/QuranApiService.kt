package com.rahmadev.hamba.core.data.source.network.retrofit

import com.rahmadev.hamba.core.data.source.network.response.DetailSurahResponse
import com.rahmadev.hamba.core.data.source.network.response.QuranResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface QuranApiService {

    @GET("surat")
    suspend fun getSurah(): QuranResponse

    @GET("surat/{id}")
    suspend fun getSurahById(
        @Path("id") id: Int
    ): DetailSurahResponse
}