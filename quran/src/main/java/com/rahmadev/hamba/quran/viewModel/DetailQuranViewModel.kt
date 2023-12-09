package com.rahmadev.hamba.quran.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.rahmadev.hamba.core.domain.usecase.quran.QuranUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DetailQuranViewModel @Inject constructor(
    private val quranUseCase: QuranUseCase
) : ViewModel() {

    fun getSurahById(id: Int) = quranUseCase.getSurahById(id).asLiveData()
}