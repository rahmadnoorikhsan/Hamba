package com.rahmadev.hamba.core.domain.usecase.hadith

import com.rahmadev.hamba.core.domain.model.hadith.Hadith
import com.rahmadev.hamba.core.utils.Result
import kotlinx.coroutines.flow.Flow

interface HadithUseCase {

    fun getHadith(): Flow<Result<List<Hadith>>>
}