package com.rahmadev.hamba.core.data.source.network

import com.rahmadev.hamba.core.data.source.network.retrofit.AladhanApiService
import com.rahmadev.hamba.core.data.source.network.retrofit.DoaApiService
import com.rahmadev.hamba.core.data.source.network.retrofit.HadithApiService
import com.rahmadev.hamba.core.data.source.network.retrofit.QuranApiService
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RemoteDataSource @Inject constructor(
    private val aladhanApiService: AladhanApiService,
    private val hadithApiService: HadithApiService,
    private val doaApiService: DoaApiService,
    private val quranApiService: QuranApiService
) {

    suspend fun getTimeSchedule(city: String) = aladhanApiService.getTimeSchedule(city)

    suspend fun getHadith() = hadithApiService.getHadith()

    suspend fun getDoa() = doaApiService.getDoa()

    suspend fun getSurah() = quranApiService.getSurah()

    suspend fun getDetailSurah(id: Int) = quranApiService.getSurahById(id)
}