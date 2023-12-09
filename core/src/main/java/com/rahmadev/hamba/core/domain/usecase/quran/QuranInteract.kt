package com.rahmadev.hamba.core.domain.usecase.quran

import com.rahmadev.hamba.core.domain.repository.QuranRepository
import javax.inject.Inject

class QuranInteract @Inject constructor(
    private val quranRepository: QuranRepository
) : QuranUseCase {
    override fun getSurah() = quranRepository.getSurah()

    override fun getSurahById(id: Int) = quranRepository.getSurahById(id)
}