package com.rahmadev.hamba.core.domain.repository

import com.rahmadev.hamba.core.domain.model.doa.Doa
import com.rahmadev.hamba.core.utils.Result
import kotlinx.coroutines.flow.Flow

interface DoaRepository {

    fun getDoa(): Flow<Result<List<Doa>>>
}