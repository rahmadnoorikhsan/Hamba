package com.rahmadev.hamba.core.data.source.network.retrofit

import com.rahmadev.hamba.core.data.source.network.response.PrayerScheduleResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface AladhanApiService {

    @GET("timingsByAddress")
    suspend fun getTimeSchedule(
        @Query("address") address: String
    ): PrayerScheduleResponse
}