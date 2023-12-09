package com.rahmadev.hamba.core.domain.usecase.quran

import com.rahmadev.hamba.core.domain.model.quran.Quran
import com.rahmadev.hamba.core.domain.model.quran.Surah
import com.rahmadev.hamba.core.utils.Result
import kotlinx.coroutines.flow.Flow

interface QuranUseCase {

    fun getSurah(): Flow<Result<List<Quran>>>

    fun getSurahById(id: Int): Flow<Result<Surah>>
}