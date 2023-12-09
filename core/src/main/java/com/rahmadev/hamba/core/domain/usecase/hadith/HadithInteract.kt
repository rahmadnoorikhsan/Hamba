package com.rahmadev.hamba.core.domain.usecase.hadith

import com.rahmadev.hamba.core.domain.repository.HadithRepository
import javax.inject.Inject

class HadithInteract @Inject constructor(
    private val hadithRepository: HadithRepository
) : HadithUseCase {
    override fun getHadith() = hadithRepository.getHadith()
}