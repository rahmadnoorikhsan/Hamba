package com.rahmadev.hamba.core.domain.usecase.doa

import com.rahmadev.hamba.core.domain.model.doa.Doa
import com.rahmadev.hamba.core.utils.Result
import kotlinx.coroutines.flow.Flow

interface DoaUseCase {

    fun getDoa(): Flow<Result<List<Doa>>>
}