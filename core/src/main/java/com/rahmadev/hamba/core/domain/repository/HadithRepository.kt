package com.rahmadev.hamba.core.domain.repository

import com.rahmadev.hamba.core.domain.model.hadith.Hadith
import com.rahmadev.hamba.core.utils.Result
import kotlinx.coroutines.flow.Flow

interface HadithRepository {
    fun getHadith(): Flow<Result<List<Hadith>>>
}