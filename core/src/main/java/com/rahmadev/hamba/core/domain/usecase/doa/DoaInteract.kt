package com.rahmadev.hamba.core.domain.usecase.doa

import com.rahmadev.hamba.core.domain.repository.DoaRepository
import javax.inject.Inject

class DoaInteract @Inject constructor(
    private val doaRepository: DoaRepository
) : DoaUseCase {
    override fun getDoa() = doaRepository.getDoa()
}